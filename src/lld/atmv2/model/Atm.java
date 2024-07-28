package lld.atmv2.model;

import lld.atmv2.atmstate.AtmState;
import lld.atmv2.atmstate.IdleState;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Atm {
    private static Atm instance=null;
    private AtmState atmState;
    private Bank bank;
    private int atmBalance;
    private int noOfOneHundredNotes;
    private int noOfFiveHundredNotes;
    private int noOfTwoThousandNotes;

    private Atm(Bank bank){
        this.bank = bank;
        setAtmState(new IdleState());
    }

    public static Atm getInstance(Bank bank){
        if(instance==null){
            instance=new Atm(bank);
        }
        return instance;
    }

    public void setAtmBalance(int availableAmount, int noOfOneHundredNote, int noOfFiveHundredNote, int noOfTwoThousandNote){
        this.atmBalance =availableAmount;
        this.noOfOneHundredNotes =noOfOneHundredNote;
        this.noOfFiveHundredNotes =noOfFiveHundredNote;
        this.noOfTwoThousandNotes =noOfTwoThousandNote;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductUserBalance(User user, int amount) {
        double balance = this.bank.getDetails().get(user).getBalance();
        this.bank.getDetails().get(user).setBalance(balance - amount);
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public AtmState getAtmState() {
        return atmState;
    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
