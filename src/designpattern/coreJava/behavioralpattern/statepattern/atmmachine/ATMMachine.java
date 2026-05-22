package designpattern.coreJava.behavioralpattern.statepattern.atmmachine;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.state.ATMState;
import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.state.NoCardState;

public class ATMMachine {
    private ATMState currentState;
    private int balance = 10000;

    public ATMMachine() {
        this.currentState = new NoCardState();
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public int getBalance() {
        return balance;
    }

    public void deductBalance(int amount) {
        balance -= amount;
    }

    // Delegate actions to current state
    public void insertCard(){
        currentState.insertCard(this);
    }
    public void ejectCard(){
        currentState.ejectCard(this);
    }
    public void enterPin(int pin){
        currentState.enterPin(this, pin);
    }
    public void withdrawCash(int amount){
        currentState.withdrawCash(this,amount);
    }

}
