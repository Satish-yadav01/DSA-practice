package designpattern.coreJava.behavioralpattern.statepattern.atmmachine;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.state.ATMState;
import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.state.NoCardState;

public class ATMMachine {
    private ATMState currentState;
    private int balance = 100000;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;


    public ATMMachine() {
        this.currentState = new NoCardState();
        this.noOfTwoThousandNotes = 10;
        this.noOfFiveHundredNotes = 50;
        this.noOfOneHundredNotes = 100;
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

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductTwoThousandNotes(int notes){
        this.noOfTwoThousandNotes -= notes;
    }

    public void deductFiveHundredNotes(int notes){
        this.noOfFiveHundredNotes -= notes;
    }

    public void deductOneHundredNotes(int notes){
        this.noOfOneHundredNotes -=notes;
    }
}
