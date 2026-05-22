package designpattern.coreJava.behavioralpattern.statepattern.atmmachine.state;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.ATMMachine;

public class NoCardState implements ATMState{

    @Override
    public void insertCard(ATMMachine atm) {
        System.out.println("Card inserted");
        atm.setCurrentState(new HasCardState());
    }

    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("No card to eject");
    }

    @Override
    public void enterPin(ATMMachine atm, int pin) {
        System.out.println("Insert card first");
    }

    @Override
    public void withdrawCash(ATMMachine atm, int amount) {
        System.out.println("Insert card first");
    }
}
