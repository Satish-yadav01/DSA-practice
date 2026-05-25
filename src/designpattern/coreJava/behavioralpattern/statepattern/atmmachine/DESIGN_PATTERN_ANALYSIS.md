# ATM Machine - Design Pattern Analysis & LLD Documentation

## Executive Summary

The ATM Machine implementation is a well-designed system that demonstrates two behavioral design patterns:
1. **State Pattern** - For managing ATM states and transitions
2. **Chain of Responsibility Pattern** - For processing cash withdrawals in denominations

---

## 1. Design Pattern Analysis

### 1.1 State Pattern (Primary Pattern)

#### What is State Pattern?
The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class. It's used to eliminate large conditional statements and encapsulate state-specific behavior.

#### How it's Applied in ATM Machine:

**Problem Solved:**
- Without State Pattern, ATMMachine would have complex if-else logic to handle different states
- Each operation (insertCard, ejectCard, enterPin, withdrawCash) would need to check current state

**Solution:**
- Created `ATMState` interface with all possible operations
- Implemented concrete states: `NoCardState`, `HasCardState`, `CashWithdrawalState`
- Each state encapsulates its own behavior
- ATMMachine delegates operations to current state

**State Transitions:**
```
NoCardState
    ↓ (insertCard)
HasCardState
    ↓ (enterPin with correct PIN)
CashWithdrawalState
    ↓ (ejectCard)
NoCardState
```

#### Benefits in This Implementation:
1. **Encapsulation:** Each state's logic is isolated
2. **Easy to Extend:** Adding new states (e.g., PinRetryState) is straightforward
3. **Eliminates Conditionals:** No large if-else chains in ATMMachine
4. **Single Responsibility:** Each state class has one reason to change
5. **Open/Closed Principle:** Open for extension, closed for modification

#### Code Example:
```java
// Without State Pattern (Bad)
public void insertCard() {
    if (state == NO_CARD) {
        state = HAS_CARD;
        System.out.println("Card inserted");
    } else if (state == HAS_CARD) {
        System.out.println("Card already inserted");
    } else if (state == CASH_WITHDRAWAL) {
        System.out.println("Card already inserted");
    }
}

// With State Pattern (Good)
public void insertCard() {
    currentState.insertCard(this);
}
```

---

### 1.2 Chain of Responsibility Pattern (Secondary Pattern)

#### What is Chain of Responsibility Pattern?
The Chain of Responsibility Pattern allows passing requests along a chain of handlers. Each handler decides either to process the request or pass it to the next handler in the chain.

#### How it's Applied in ATM Machine:

**Problem Solved:**
- Cash withdrawal needs to be processed in specific denominations (2000, 500, 100)
- Without this pattern, would need complex logic to calculate and dispense notes

**Solution:**
- Created abstract `CashWithdrawProcess` class
- Implemented concrete handlers for each denomination
- Each handler processes its denomination and passes remainder to next handler
- Chain is: 2000 → 500 → 100 → null

**Chain Structure:**
```
TwoThousandCashWithdrawProcess
    ↓ (next)
FiveHundredCashWithdrawProcess
    ↓ (next)
OneHundredCashWithdrawProcess
    ↓ (next)
null
```

#### Benefits in This Implementation:
1. **Separation of Concerns:** Each denomination handler is independent
2. **Flexibility:** Easy to add new denominations
3. **Reusability:** Handlers can be reused in different chains
4. **Single Responsibility:** Each handler focuses on one denomination
5. **Dynamic Chain:** Chain can be modified at runtime

#### Code Example:
```java
// Chain Initialization in CashWithdrawalState
this.cashWithdrawProcess = new TwoThousandCashWithdrawProcess(
    new FiveHundredCashWithdrawProcess(
        new OneHundredCashWithdrawProcess(null)
    )
);

// Processing
public void withdrawCash(ATMMachine atm, int amount) {
    if (atm.getBalance() >= amount) {
        atm.deductBalance(amount);
        cashWithdrawProcess.withdraw(atm, (double)amount);
    }
}
```

---

## 2. Class Hierarchy & Relationships

### 2.1 State Pattern Classes

```
ATMState (Interface)
├── NoCardState
├── HasCardState
└── CashWithdrawalState
```

**ATMState Interface:**
- Defines contract for all states
- Methods: insertCard, ejectCard, enterPin, withdrawCash

**NoCardState:**
- Initial state of ATM
- Only insertCard() is valid operation
- Other operations print error messages

**HasCardState:**
- Card is inserted but PIN not verified
- Valid operations: insertCard (error), ejectCard, enterPin
- enterPin with correct PIN transitions to CashWithdrawalState

**CashWithdrawalState:**
- PIN is verified, user can withdraw cash
- Contains chain of responsibility for cash processing
- Valid operations: ejectCard, withdrawCash

### 2.2 Chain of Responsibility Classes

```
CashWithdrawProcess (Abstract)
├── TwoThousandCashWithdrawProcess
├── FiveHundredCashWithdrawProcess
└── OneHundredCashWithdrawProcess
```

**CashWithdrawProcess (Abstract):**
- Base class for all handlers
- Maintains reference to next handler
- Default withdraw() delegates to next handler

**TwoThousandCashWithdrawProcess:**
- Processes 2000 denomination notes
- Calculates: remainingNotes = amount / 2000
- Deducts available notes
- Passes remainder to next handler

**FiveHundredCashWithdrawProcess:**
- Processes 500 denomination notes
- Calculates: remainingNotes = amount / 500
- Deducts available notes
- Passes remainder to next handler

**OneHundredCashWithdrawProcess:**
- Processes 100 denomination notes
- Calculates: remainingNotes = amount / 100
- Deducts available notes
- Final handler in chain

### 2.3 Context Class

**ATMMachine:**
- Maintains current state
- Maintains account balance
- Maintains note counts for each denomination
- Delegates all operations to current state
- Provides methods to modify state and balance

---

## 3. Detailed Workflow Analysis

### 3.1 Successful Withdrawal Scenario

**Scenario:** User withdraws 5800 rupees

**Step-by-Step Execution:**

1. **Initial State:** NoCardState
   ```
   ATMMachine atm = new ATMMachine();
   // currentState = NoCardState
   ```

2. **Insert Card:**
   ```
   atm.insertCard();
   // NoCardState.insertCard() called
   // Transitions to HasCardState
   // Output: "Card inserted"
   ```

3. **Enter PIN:**
   ```
   atm.enterPin(1234);
   // HasCardState.enterPin() called
   // PIN verified (1234 == 1234)
   // Transitions to CashWithdrawalState
   // Output: "PIN verified"
   ```

4. **Withdraw Cash:**
   ```
   atm.withdrawCash(5800);
   // CashWithdrawalState.withdrawCash() called
   // Check: balance (100000) >= amount (5800) ✓
   // Deduct balance: 100000 - 5800 = 94200
   // Call cashWithdrawProcess.withdraw(atm, 5800)
   ```

5. **Chain Processing:**

   **Handler 1: TwoThousandCashWithdrawProcess**
   ```
   remainingNotes = 5800 / 2000 = 2
   balance = 5800 % 2000 = 1800
   
   Available notes: 10 >= 2 ✓
   Deduct: noOfTwoThousandNotes = 10 - 2 = 8
   
   Output: "2000 Notes: 2"
   Pass 1800 to next handler
   ```

   **Handler 2: FiveHundredCashWithdrawProcess**
   ```
   remainingNotes = 1800 / 500 = 3
   balance = 1800 % 500 = 300
   
   Available notes: 50 >= 3 ✓
   Deduct: noOfFiveHundredNotes = 50 - 3 = 47
   
   Output: "500 Notes: 3"
   Pass 300 to next handler
   ```

   **Handler 3: OneHundredCashWithdrawProcess**
   ```
   remainingNotes = 300 / 100 = 3
   balance = 300 % 100 = 0
   
   Available notes: 100 >= 3 ✓
   Deduct: noOfOneHundredNotes = 100 - 3 = 97
   
   Output: "100 Notes: 3"
   No remaining amount, chain ends
   ```

6. **Final State:** CashWithdrawalState
   ```
   Output: "Remaining balance: 94200"
   ```

### 3.2 Invalid Operation Scenario

**Scenario:** User tries to withdraw without inserting card

```
ATMMachine atm = new ATMMachine();
atm.withdrawCash(1000);
// NoCardState.withdrawCash() called
// Output: "Insert card first"
// No state transition
```

### 3.3 Insufficient Balance Scenario

**Scenario:** User tries to withdraw more than balance

```
atm.withdrawCash(150000);
// CashWithdrawalState.withdrawCash() called
// Check: balance (94200) >= amount (150000) ✗
// Output: "Insufficient balance"
// No state transition, no chain processing
```

---

## 4. Key Design Principles Applied

### 4.1 SOLID Principles

**Single Responsibility Principle (SRP):**
- Each state class has one reason to change (its state logic)
- Each handler class has one reason to change (its denomination logic)
- ATMMachine only manages state transitions

**Open/Closed Principle (OCP):**
- Open for extension: Can add new states without modifying existing code
- Closed for modification: Existing states don't need changes
- Example: Adding PinRetryState doesn't affect other states

**Liskov Substitution Principle (LSP):**
- All state implementations can be substituted for ATMState interface
- All handler implementations can be substituted for CashWithdrawProcess
- No special handling needed for specific implementations

**Interface Segregation Principle (ISP):**
- ATMState interface is focused and minimal
- Clients only depend on methods they use
- No unnecessary methods in interface

**Dependency Inversion Principle (DIP):**
- ATMMachine depends on ATMState abstraction, not concrete states
- CashWithdrawalState depends on CashWithdrawProcess abstraction
- High-level modules don't depend on low-level modules

### 4.2 Other Design Principles

**Encapsulation:**
- State-specific behavior is encapsulated in state classes
- ATMMachine doesn't expose internal state details

**Composition over Inheritance:**
- ATMMachine uses composition (has-a) with ATMState
- CashWithdrawalState uses composition with CashWithdrawProcess

**Separation of Concerns:**
- State management is separate from cash processing
- Each concern is handled by appropriate pattern

---

## 5. Extensibility & Maintenance

### 5.1 Adding New States

**Example: Adding PinRetryState**

```java
public class PinRetryState implements ATMState {
    private int retryCount = 0;
    private static final int MAX_RETRIES = 3;
    
    @Override
    public void enterPin(ATMMachine atm, int pin) {
        if (pin == 1234) {
            System.out.println("PIN verified");
            atm.setCurrentState(new CashWithdrawalState());
        } else {
            retryCount++;
            if (retryCount >= MAX_RETRIES) {
                System.out.println("Card blocked");
                atm.setCurrentState(new CardBlockedState());
            } else {
                System.out.println("Invalid PIN. Retries left: " + (MAX_RETRIES - retryCount));
            }
        }
    }
    
    // Other methods...
}
```

**Changes needed:**
- Create new PinRetryState class
- Modify HasCardState to transition to PinRetryState instead of CashWithdrawalState
- No changes to ATMMachine or other states

### 5.2 Adding New Denominations

**Example: Adding 5000 denomination**

```java
public class FiveThousandCashWithdrawProcess extends CashWithdrawProcess {
    public static final int FIVE_THOUSAND_NOTE = 5000;
    
    public FiveThousandCashWithdrawProcess(CashWithdrawProcess next) {
        super(next);
    }
    
    @Override
    public void withdraw(ATMMachine atm, double amount) {
        int remainingNotes = (int) (amount / FIVE_THOUSAND_NOTE);
        int balance = (int) (amount % FIVE_THOUSAND_NOTE);
        
        // Process 5000 notes
        // Deduct from ATM
        // Pass remainder to next handler
    }
}
```

**Changes needed:**
- Create new FiveThousandCashWithdrawProcess class
- Modify CashWithdrawalState to include new handler in chain
- Add note count fields to ATMMachine
- No changes to existing handlers

---

## 6. Potential Improvements

### 6.1 Current Limitations

1. **Hard-coded PIN:** PIN is hard-coded as 1234
   - Should be validated against database

2. **No Transaction History:** No logging of transactions
   - Should maintain transaction records

3. **No Concurrent Access:** Not thread-safe
   - Should use synchronization for multi-threaded environment

4. **Limited Error Handling:** Basic error messages
   - Should have custom exceptions

5. **No Denomination Validation:** Doesn't validate if exact amount can be dispensed
   - Should check if amount can be made with available denominations

### 6.2 Suggested Enhancements

**1. Add Transaction Service:**
```java
public interface TransactionService {
    void logTransaction(String type, int amount, boolean success);
    List<Transaction> getTransactionHistory();
}
```

**2. Add Custom Exceptions:**
```java
public class InsufficientBalanceException extends Exception {}
public class InvalidPinException extends Exception {}
public class CardBlockedException extends Exception {}
```

**3. Add Denomination Validator:**
```java
public interface DenominationValidator {
    boolean canDispense(int amount);
    List<Integer> getOptimalDenominations(int amount);
}
```

**4. Add Thread Safety:**
```java
public synchronized void withdrawCash(int amount) {
    // Thread-safe implementation
}
```

---

## 7. Testing Strategy

### 7.1 Unit Tests

**Test State Transitions:**
```java
@Test
public void testNoCardToHasCardTransition() {
    ATMMachine atm = new ATMMachine();
    atm.insertCard();
    assertTrue(atm.getCurrentState() instanceof HasCardState);
}

@Test
public void testHasCardToCashWithdrawalTransition() {
    ATMMachine atm = new ATMMachine();
    atm.insertCard();
    atm.enterPin(1234);
    assertTrue(atm.getCurrentState() instanceof CashWithdrawalState);
}
```

**Test Invalid Operations:**
```java
@Test
public void testWithdrawWithoutCard() {
    ATMMachine atm = new ATMMachine();
    atm.withdrawCash(1000);
    assertEquals(100000, atm.getBalance()); // Balance unchanged
}
```

**Test Cash Withdrawal:**
```java
@Test
public void testCashWithdrawal() {
    ATMMachine atm = new ATMMachine();
    atm.insertCard();
    atm.enterPin(1234);
    atm.withdrawCash(5800);
    assertEquals(94200, atm.getBalance());
    assertEquals(8, atm.getNoOfTwoThousandNotes());
    assertEquals(47, atm.getNoOfFiveHundredNotes());
    assertEquals(97, atm.getNoOfOneHundredNotes());
}
```

### 7.2 Integration Tests

**Test Complete Workflow:**
```java
@Test
public void testCompleteWithdrawalWorkflow() {
    ATMMachine atm = new ATMMachine();
    
    // Insert card
    atm.insertCard();
    assertTrue(atm.getCurrentState() instanceof HasCardState);
    
    // Enter PIN
    atm.enterPin(1234);
    assertTrue(atm.getCurrentState() instanceof CashWithdrawalState);
    
    // Withdraw cash
    atm.withdrawCash(5800);
    assertEquals(94200, atm.getBalance());
    
    // Eject card
    atm.ejectCard();
    assertTrue(atm.getCurrentState() instanceof NoCardState);
}
```

---

## 8. Comparison with Alternative Approaches

### 8.1 Without State Pattern

**Disadvantages:**
- Large if-else statements in every method
- Difficult to add new states
- State logic scattered across multiple methods
- Hard to maintain and test

### 8.2 Without Chain of Responsibility

**Disadvantages:**
- Complex logic to calculate denominations
- Difficult to add new denominations
- Tight coupling between denomination handlers
- Hard to reuse handlers

### 8.3 Using Enum for States

**Disadvantages:**
- All state logic in one place
- Violates Single Responsibility Principle
- Difficult to add state-specific behavior
- Not extensible

---

## 9. Conclusion

The ATM Machine implementation is an excellent example of applying design patterns to solve real-world problems:

1. **State Pattern** elegantly handles state transitions and encapsulates state-specific behavior
2. **Chain of Responsibility Pattern** cleanly processes cash withdrawal in denominations
3. **SOLID Principles** are well-applied throughout the design
4. **Extensibility** is built-in for adding new states and denominations
5. **Maintainability** is high due to clear separation of concerns

This design serves as a reference implementation for understanding and applying behavioral design patterns in Java.

---

## 10. References

- **State Pattern:** Gang of Four Design Patterns
- **Chain of Responsibility Pattern:** Gang of Four Design Patterns
- **SOLID Principles:** Robert C. Martin (Uncle Bob)
- **Design Patterns in Java:** Joshua Bloch, Effective Java
