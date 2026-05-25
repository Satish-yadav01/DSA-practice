# ATM Machine LLD - Quick Reference Guide

## System Overview

The ATM Machine system demonstrates a well-architected solution using two behavioral design patterns to manage state transitions and cash withdrawal processing.

---

## Pattern Summary

| Aspect | State Pattern | Chain of Responsibility |
|--------|---------------|------------------------|
| **Purpose** | Manage state transitions | Process cash in denominations |
| **Problem** | Complex if-else for states | Complex denomination logic |
| **Solution** | Encapsulate state behavior | Chain handlers for each denomination |
| **Location** | ATMState interface & implementations | CashWithdrawProcess hierarchy |
| **Benefit** | Easy to add states | Easy to add denominations |

---

## Class Structure

### State Pattern Classes

```
ATMState (Interface)
├── NoCardState
│   └── Initial state, only insertCard() valid
├── HasCardState
│   └── Card inserted, PIN verification pending
└── CashWithdrawalState
    └── PIN verified, cash withdrawal allowed
```

### Chain of Responsibility Classes

```
CashWithdrawProcess (Abstract)
├── TwoThousandCashWithdrawProcess (2000 notes)
├── FiveHundredCashWithdrawProcess (500 notes)
└── OneHundredCashWithdrawProcess (100 notes)
```

### Context Class

```
ATMMachine
├── Maintains current state
├── Maintains balance
├── Maintains note counts
└── Delegates operations to state
```

---

## State Transitions

```
┌─────────────────┐
│  NoCardState    │ ◄─────────────────┐
└────────┬────────┘                   │
         │ insertCard()               │
         ▼                            │
┌─────────────────┐                   │
│  HasCardState   │                   │
└────────┬────────┘                   │
         │ enterPin(1234)             │
         ▼                            │
┌──────────────────────┐              │
│ CashWithdrawalState  │              │
└────────┬─────────────┘              │
         │ ejectCard()                │
         └────────────────────────────┘
```

---

## Key Methods

### ATMMachine
- `insertCard()` - Insert card into ATM
- `ejectCard()` - Eject card from ATM
- `enterPin(int pin)` - Enter PIN for verification
- `withdrawCash(int amount)` - Withdraw cash
- `setCurrentState(ATMState)` - Change state
- `deductBalance(int amount)` - Reduce balance
- `deductXXXNotes(int notes)` - Reduce note count

### ATMState Interface
- `insertCard(ATMMachine atm)` - Handle card insertion
- `ejectCard(ATMMachine atm)` - Handle card ejection
- `enterPin(ATMMachine atm, int pin)` - Handle PIN entry
- `withdrawCash(ATMMachine atm, int amount)` - Handle withdrawal

### CashWithdrawProcess
- `withdraw(ATMMachine atm, double amount)` - Process withdrawal

---

## Workflow Example: Withdraw 5800

```
1. Initial State: NoCardState
   Balance: 100000
   Notes: 2000x10, 500x50, 100x100

2. insertCard()
   → NoCardState.insertCard()
   → Transition to HasCardState
   Output: "Card inserted"

3. enterPin(1234)
   → HasCardState.enterPin()
   → PIN verified
   → Transition to CashWithdrawalState
   Output: "PIN verified"

4. withdrawCash(5800)
   → CashWithdrawalState.withdrawCash()
   → Check: 100000 >= 5800 ✓
   → Deduct balance: 100000 - 5800 = 94200
   → Process chain:

   TwoThousandCashWithdrawProcess:
   - Notes needed: 5800 / 2000 = 2
   - Available: 10 >= 2 ✓
   - Deduct: 10 - 2 = 8
   - Remaining: 1800
   Output: "2000 Notes: 2"

   FiveHundredCashWithdrawProcess:
   - Notes needed: 1800 / 500 = 3
   - Available: 50 >= 3 ✓
   - Deduct: 50 - 3 = 47
   - Remaining: 300
   Output: "500 Notes: 3"

   OneHundredCashWithdrawProcess:
   - Notes needed: 300 / 100 = 3
   - Available: 100 >= 3 ✓
   - Deduct: 100 - 3 = 97
   - Remaining: 0
   Output: "100 Notes: 3"

5. Final State: CashWithdrawalState
   Balance: 94200
   Notes: 2000x8, 500x47, 100x97
   Output: "Remaining balance: 94200"

6. ejectCard()
   → CashWithdrawalState.ejectCard()
   → Transition to NoCardState
   Output: "Card ejected"
```

---

## Design Principles Applied

### SOLID Principles

| Principle | Application |
|-----------|-------------|
| **SRP** | Each state/handler has single responsibility |
| **OCP** | Open for new states/handlers, closed for modification |
| **LSP** | All states/handlers are substitutable |
| **ISP** | Minimal, focused interfaces |
| **DIP** | Depend on abstractions, not concrete classes |

### Other Principles

- **Encapsulation:** State behavior is encapsulated
- **Composition:** Uses composition over inheritance
- **Separation of Concerns:** State management separate from cash processing

---

## Extensibility Points

### Adding New States

1. Create new class implementing ATMState
2. Implement all interface methods
3. Define state-specific behavior
4. Update transition logic in existing states

**Example: PinRetryState**
```java
public class PinRetryState implements ATMState {
    private int retryCount = 0;
    
    @Override
    public void enterPin(ATMMachine atm, int pin) {
        if (pin == 1234) {
            atm.setCurrentState(new CashWithdrawalState());
        } else {
            retryCount++;
            if (retryCount >= 3) {
                atm.setCurrentState(new CardBlockedState());
            }
        }
    }
    // Other methods...
}
```

### Adding New Denominations

1. Create new class extending CashWithdrawProcess
2. Implement denomination-specific logic
3. Update chain initialization in CashWithdrawalState
4. Add note count fields to ATMMachine

**Example: 5000 denomination**
```java
public class FiveThousandCashWithdrawProcess extends CashWithdrawProcess {
    public static final int FIVE_THOUSAND_NOTE = 5000;
    
    @Override
    public void withdraw(ATMMachine atm, double amount) {
        // Process 5000 notes
        // Pass remainder to next handler
    }
}
```

---

## Testing Checklist

### State Transitions
- [ ] NoCard → HasCard (insertCard)
- [ ] HasCard → CashWithdrawal (enterPin with correct PIN)
- [ ] CashWithdrawal �� NoCard (ejectCard)
- [ ] Invalid transitions are rejected

### Cash Withdrawal
- [ ] Correct denominations are calculated
- [ ] Note counts are decremented correctly
- [ ] Balance is updated correctly
- [ ] Insufficient balance is handled
- [ ] Insufficient notes are handled

### Invalid Operations
- [ ] Cannot withdraw without card
- [ ] Cannot withdraw without PIN
- [ ] Cannot insert card twice
- [ ] Cannot eject card twice

---

## Performance Considerations

| Aspect | Current | Optimization |
|--------|---------|--------------|
| **State Lookup** | O(1) | Already optimal |
| **Chain Processing** | O(n) where n=denominations | Acceptable for small chains |
| **Balance Update** | O(1) | Already optimal |
| **Thread Safety** | Not thread-safe | Add synchronization if needed |

---

## Security Considerations

### Current Implementation
- Hard-coded PIN (1234)
- No transaction logging
- No card validation
- No rate limiting

### Recommended Enhancements
1. Validate PIN against database
2. Log all transactions
3. Validate card details
4. Implement rate limiting for PIN attempts
5. Add encryption for sensitive data
6. Implement audit trail

---

## Common Issues & Solutions

### Issue 1: Adding New State
**Problem:** Need to add new state but don't know where to start
**Solution:** 
1. Create class implementing ATMState
2. Implement all interface methods
3. Update transition logic in related states
4. Test state transitions

### Issue 2: Changing Denomination Logic
**Problem:** Need to modify how cash is dispensed
**Solution:**
1. Modify specific handler class
2. No changes needed to other handlers
3. Chain structure remains same
4. Test withdrawal scenarios

### Issue 3: Adding New Denomination
**Problem:** Need to support new denomination
**Solution:**
1. Create new handler class
2. Insert into chain at appropriate position
3. Update ATMMachine note count fields
4. Test withdrawal scenarios

---

## Code Quality Metrics

| Metric | Status | Notes |
|--------|--------|-------|
| **Cohesion** | High | Each class has clear purpose |
| **Coupling** | Low | Depends on abstractions |
| **Complexity** | Low | Simple, readable code |
| **Maintainability** | High | Easy to understand and modify |
| **Testability** | High | Each component can be tested independently |
| **Extensibility** | High | Easy to add new states/handlers |

---

## Comparison with Alternatives

### Without State Pattern
```
// Complex if-else logic
public void insertCard() {
    if (state == NO_CARD) {
        state = HAS_CARD;
    } else if (state == HAS_CARD) {
        // error
    } else if (state == CASH_WITHDRAWAL) {
        // error
    }
}
```

### With State Pattern
```
// Clean, delegated logic
public void insertCard() {
    currentState.insertCard(this);
}
```

---

## Conclusion

The ATM Machine implementation is a textbook example of applying design patterns to solve real-world problems:

✓ **State Pattern** elegantly manages state transitions
✓ **Chain of Responsibility** cleanly processes denominations
✓ **SOLID Principles** ensure maintainability
✓ **Extensibility** is built-in for future enhancements
✓ **Clean Code** makes it easy to understand and modify

This design serves as an excellent reference for understanding behavioral design patterns in Java.

---

## Files Generated

1. **ATM_LLD_CLASS_DIAGRAM.md** - Detailed class diagram and descriptions
2. **DESIGN_PATTERN_ANALYSIS.md** - In-depth pattern analysis
3. **ATM_LLD_DIAGRAM.puml** - PlantUML class diagram
4. **STATE_TRANSITIONS.puml** - PlantUML state diagram
5. **WITHDRAWAL_SEQUENCE.puml** - PlantUML sequence diagram
6. **ATM_QUICK_REFERENCE.md** - This quick reference guide

---

## How to Use These Documents

1. **Start with this file** for quick overview
2. **Read ATM_LLD_CLASS_DIAGRAM.md** for detailed structure
3. **Read DESIGN_PATTERN_ANALYSIS.md** for deep understanding
4. **View PlantUML diagrams** for visual representation
5. **Use as reference** when implementing similar patterns

---

## Additional Resources

- Gang of Four Design Patterns Book
- Refactoring Guru Design Patterns
- Joshua Bloch - Effective Java
- Robert C. Martin - Clean Code
- SOLID Principles Documentation
