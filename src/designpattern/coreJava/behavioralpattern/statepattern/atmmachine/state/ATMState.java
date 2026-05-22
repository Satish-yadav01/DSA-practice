package designpattern.coreJava.behavioralpattern.statepattern.atmmachine.state;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.ATMMachine;

public interface ATMState {
    void insertCard(ATMMachine atm);
    void ejectCard(ATMMachine atm);
    void enterPin(ATMMachine atm, int pin);
    void withdrawCash(ATMMachine atm, int amount);
}
