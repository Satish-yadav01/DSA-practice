# ATM Machine - Low Level Design (LLD) Class Diagram

## Design Pattern Analysis

### Primary Pattern: **State Pattern**
The ATM Machine implementation uses the **State Pattern** (Behavioral Pattern) to manage different states of the ATM machine and handle state transitions.

### Secondary Pattern: **Chain of Responsibility Pattern**
The cash withdrawal process uses the **Chain of Responsibility Pattern** to process cash withdrawal in denominations (2000, 500, 100).

---

## Class Diagram

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                          ATM MACHINE SYSTEM                                 │
└─────────────────────────────────────────────────────────────────────────���───┘

                              ┌──────────────────┐
                              │   ATMMachine     │
                              ├──────────────────┤
                              │ - currentState   │
                              │ - balance        │
                              │ - noOfTwoThousandNotes
                              │ - noOfFiveHundredNotes
                              │ - noOfOneHundredNotes
                              ├──────────────────┤
                              │ + insertCard()   │
                              │ + ejectCard()    │
                              │ + enterPin()     │
                              │ + withdrawCash() │
                              │ + getBalance()   │
                              │ + deductBalance()│
                              │ + setCurrentState()
                              │ + getNoOfXXXNotes()
                              │ + deductXXXNotes()
                              └────────┬─────────┘
                                       │
                                       │ uses
                                       │
                    ┌──────────────────▼──────────────────┐
                    │      <<interface>>                  │
                    │         ATMState                    │
                    ├─────────────────────────────────────┤
                    │ + insertCard(ATMMachine)            │
                    │ + ejectCard(ATMMachine)             │
                    │ + enterPin(ATMMachine, int)         │
                    │ + withdrawCash(ATMMachine, int)     │
                    └──────────────────┬──────────────────┘
                                       │
                    ┌──────────────────┼──────────────────┐
                    │                  │                  │
        ┌───────────▼────────┐ ┌──────▼──────────┐ ┌────▼──────────────┐
        │   NoCardState      │ │  HasCardState   │ │ CashWithdrawalState
        ├────────────────────┤ ├─────────────────┤ ├───────────────────┤
        │ + insertCard()     │ │ + insertCard()  │ │ - cashWithdraw    │
        │ + ejectCard()      │ │ + ejectCard()   │ │   Process         │
        │ + enterPin()       │ │ + enterPin()    │ ├───────────────────┤
        │ + withdrawCash()   │ │ + withdrawCash()│ │ + insertCard()    │
        └────────────────────┘ └─────────────────┘ │ + ejectCard()     │
                                                    │ + enterPin()      │
                                                    │ + withdrawCash()  │
                                                    └────────┬──────────┘
                                                             │
                                                             │ uses
                                                             │
                                    ┌────────────────────────▼────────────────┐
                                    │  CashWithdrawProcess (Abstract)         │
                                    ├─────────────────────────────────────────┤
                                    │ # nextCashWithdrawProcess               │
                                    ├─────────────────────────────────────────┤
                                    │ # CashWithdrawProcess(next)             │
                                    │ + withdraw(ATMMachine, double)          │
                                    └────────────────────┬────────────────────┘
                                                         │
                        ┌────────────────────────────────┼────────────────────────────────┐
                        │                                │                                │
        ┌───────────────▼──────────────┐  ┌─────────────▼──────────────┐  ┌─────────────▼──────────────┐
        │ TwoThousandCashWithdraw      │  │ FiveHundredCashWithdraw    │  │ OneHundredCashWithdraw     │
        │ Process                      │  │ Process                    │  │ Process                    │
        ├──────────────────────────────┤  ├────────────────────────────┤  ├────────────────────────────┤
        │ - TWO_THOUSAND_NOTE = 2000   │  │ - FIVE_HUNDRED_NOTE = 500  │  │ - ONE_HUNDRED_NOTE = 100   │
        ├──────────────────────────────┤  ├────────────────────────────┤  ├────────────────────────────┤
        │ + withdraw(ATMMachine,       │  │ + withdraw(ATMMachine,     │  │ + withdraw(ATMMachine,     │
        │   double)                    │  │   double)                  │  │   double)                  │
        └──────────────────────────────┘  └────────────────────────────┘  └────────────────────────────┘


                                    CHAIN OF RESPONSIBILITY
                                    (Cash Withdrawal Chain)

        TwoThousandCashWithdrawProcess
                    │
                    ├─► FiveHundredCashWithdrawProcess
                                    │
                                    ├─► OneHundredCashWithdrawProcess
                                                    │
                                                    └─► null
```

---

## Detailed Class Descriptions

### 1. **ATMMachine** (Context Class)
**Responsibility:** Maintains the current state and delegates operations to the state object.

**Attributes:**
- `currentState: ATMState` - Current state of the ATM
- `balance: int` - Account balance
- `noOfTwoThousandNotes: int` - Count of 2000 denomination notes
- `noOfFiveHundredNotes: int` - Count of 500 denomination notes
- `noOfOneHundredNotes: int` - Count of 100 denomination notes

**Methods:**
- `insertCard()` - Delegates to current state
- `ejectCard()` - Delegates to current state
- `enterPin(int pin)` - Delegates to current state
- `withdrawCash(int amount)` - Delegates to current state
- `setCurrentState(ATMState)` - Changes the current state
- `deductBalance(int amount)` - Reduces balance
- `deductXXXNotes(int notes)` - Reduces note counts

---

### 2. **ATMState** (State Interface)
**Responsibility:** Defines the interface for all concrete states.

**Methods:**
- `insertCard(ATMMachine atm)` - Handle card insertion
- `ejectCard(ATMMachine atm)` - Handle card ejection
- `enterPin(ATMMachine atm, int pin)` - Handle PIN entry
- `withdrawCash(ATMMachine atm, int amount)` - Handle cash withdrawal

---

### 3. **NoCardState** (Concrete State)
**Responsibility:** Represents the state when no card is inserted.

**Behavior:**
- `insertCard()` → Transitions to `HasCardState`
- `ejectCard()` → Invalid operation (prints message)
- `enterPin()` → Invalid operation (prints message)
- `withdrawCash()` → Invalid operation (prints message)

---

### 4. **HasCardState** (Concrete State)
**Responsibility:** Represents the state when a card is inserted but PIN not verified.

**Behavior:**
- `insertCard()` → Invalid operation (card already inserted)
- `ejectCard()` → Transitions to `NoCardState`
- `enterPin(pin)` → If PIN is 1234, transitions to `CashWithdrawalState`; otherwise, stays in same state
- `withdrawCash()` → Invalid operation (PIN not verified)

---

### 5. **CashWithdrawalState** (Concrete State)
**Responsibility:** Represents the state when PIN is verified and user can withdraw cash.

**Attributes:**
- `cashWithdrawProcess: CashWithdrawProcess` - Chain of responsibility for cash withdrawal

**Behavior:**
- `insertCard()` → Invalid operation (card already inserted)
- `ejectCard()` → Transitions to `NoCardState`
- `enterPin()` → Invalid operation (PIN already verified)
- `withdrawCash(amount)` → Processes withdrawal using chain of responsibility

**Chain Initialization:**
```
TwoThousandCashWithdrawProcess
    └─► FiveHundredCashWithdrawProcess
        └─► OneHundredCashWithdrawProcess
            └─► null
```

---

### 6. **CashWithdrawProcess** (Abstract Class - Chain of Responsibility)
**Responsibility:** Base class for cash withdrawal chain handlers.

**Attributes:**
- `nextCashWithdrawProcess: CashWithdrawProcess` - Next handler in chain

**Methods:**
- `withdraw(ATMMachine, double)` - Delegates to next handler if exists

---

### 7. **TwoThousandCashWithdrawProcess** (Concrete Handler)
**Responsibility:** Handles withdrawal of 2000 denomination notes.

**Constants:**
- `TWO_THOUSAND_NOTE = 2000`

**Logic:**
1. Calculate number of 2000 notes needed
2. Deduct available notes from ATM
3. Pass remaining amount to next handler

---

### 8. **FiveHundredCashWithdrawProcess** (Concrete Handler)
**Responsibility:** Handles withdrawal of 500 denomination notes.

**Constants:**
- `FIVE_HUNDRED_NOTE = 500`

**Logic:**
1. Calculate number of 500 notes needed
2. Deduct available notes from ATM
3. Pass remaining amount to next handler

---

### 9. **OneHundredCashWithdrawProcess** (Concrete Handler)
**Responsibility:** Handles withdrawal of 100 denomination notes.

**Constants:**
- `ONE_HUNDRED_NOTE = 100`

**Logic:**
1. Calculate number of 100 notes needed
2. Deduct available notes from ATM
3. If balance remains, print error message

---

## State Transition Diagram

```
                    ┌─────────────────┐
                    │   NoCardState   │
                    └────────┬────────┘
                             │
                    insertCard()
                             │
                             ▼
                    ┌─────────────────┐
                    │  HasCardState   │
                    └────────┬────────┘
                             │
                    enterPin(1234)
                             │
                             ▼
                    ┌──────────────────────┐
                    │ CashWithdrawalState  │
                    └────────┬─────────────┘
                             │
                    ejectCard()
                             │
                             ▼
                    ┌─────────────────┐
                    │   NoCardState   │
                    └─────────────────┘
```

---

## Design Pattern Benefits

### State Pattern Benefits:
1. **Encapsulation:** Each state encapsulates its behavior
2. **Single Responsibility:** Each state class has one reason to change
3. **Open/Closed Principle:** Easy to add new states without modifying existing code
4. **Eliminates Conditional Logic:** No large if-else statements for state management

### Chain of Responsibility Benefits:
1. **Decoupling:** Senders and receivers are decoupled
2. **Flexibility:** Easy to add new denominations
3. **Single Responsibility:** Each handler focuses on one denomination
4. **Dynamic Chain:** Chain can be modified at runtime

---

## Sequence Diagram: Successful Cash Withdrawal

```
User          ATMMachine      HasCardState    CashWithdrawalState    CashWithdrawProcess
 │                │                │                    │                      │
 ├─insertCard()──►│                │                    │                      │
 │                ├─insertCard()──►│                    │                      │
 │                │◄──transition───┤                    │                      │
 │                │                │                    │                      │
 ├─enterPin()────►│                │                    │                      │
 │                ├─enterPin()────►│                    │                      │
 │                │◄──transition───┤                    │                      │
 │                │                │                    │                      │
 ├─withdrawCash()►│                │                    │                      │
 │                ├─withdrawCash()─┼───────────────────►│                      │
 │                │                │                    ├─withdraw()───────────►│
 │                │                │                    │◄──process chain───────┤
 │                │◄───balance────┬┼────────────────────┤                      │
 │◄──success──────┤                │                    │                      │
```

---

## Key Interactions

### 1. Card Insertion Flow
```
ATMMachine.insertCard()
    └─► currentState.insertCard(this)
        └─► NoCardState.insertCard()
            └─► atm.setCurrentState(new HasCardState())
```

### 2. PIN Verification Flow
```
ATMMachine.enterPin(1234)
    └─► currentState.enterPin(this, 1234)
        └─► HasCardState.enterPin()
            └─► if (pin == 1234)
                └─► atm.setCurrentState(new CashWithdrawalState())
```

### 3. Cash Withdrawal Flow
```
ATMMachine.withdrawCash(5800)
    └─► currentState.withdrawCash(this, 5800)
        └─► CashWithdrawalState.withdrawCash()
            ├─► Check balance
            ├─► Deduct balance
            └─► cashWithdrawProcess.withdraw(atm, 5800)
                ├─► TwoThousandCashWithdrawProcess.withdraw()
                │   ├─► Calculate 2000 notes: 2
                │   ├─► Deduct notes
                │   └─► Pass remaining 1800 to next
                │
                ├─► FiveHundredCashWithdrawProcess.withdraw()
                │   ├─► Calculate 500 notes: 3
                │   ├─► Deduct notes
                │   └─► Pass remaining 300 to next
                │
                └─► OneHundredCashWithdrawProcess.withdraw()
                    ├─► Calculate 100 notes: 3
                    ├─► Deduct notes
                    └─► No remaining amount
```

---

## Summary

This ATM Machine implementation demonstrates:

1. **State Pattern** for managing ATM states (NoCard, HasCard, CashWithdrawal)
2. **Chain of Responsibility Pattern** for processing cash withdrawal in denominations
3. **Proper Encapsulation** of state-specific behavior
4. **Clean Separation of Concerns** between state management and cash processing
5. **Extensibility** - Easy to add new states or denominations

The design allows the ATM to handle complex state transitions and cash withdrawal logic in a maintainable and scalable manner.
