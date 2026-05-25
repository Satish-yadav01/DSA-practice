package designpattern.coreJava.behavioralpattern.statepattern.atmmachine.state;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.ATMMachine;

public class HasCardState implements ATMState{
    @Override
    public void insertCard(ATMMachine atm) {
        System.out.println("Card already inserted");
    }

    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("Card ejected");
        atm.setCurrentState(new NoCardState());
    }

    @Override
    public void enterPin(ATMMachine atm, int pin) {
        if (pin == 1234) {
            System.out.println("PIN verified");
            atm.setCurrentState(new CashWithdrawalState());
        } else {
            System.out.println("Invalid PIN");
        }
    }

    @Override
    public void withdrawCash(ATMMachine atm, int amount) {
        System.out.println("Enter PIN first");
    }
}
