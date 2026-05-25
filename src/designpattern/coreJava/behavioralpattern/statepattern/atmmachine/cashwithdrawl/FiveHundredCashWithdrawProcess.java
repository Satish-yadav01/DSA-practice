package designpattern.coreJava.behavioralpattern.statepattern.atmmachine.cashwithdrawl;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.ATMMachine;

public class FiveHundredCashWithdrawProcess extends CashWithdrawProcess{

    public static final int FIVE_HUNDRED_NOTE = 500;
    public FiveHundredCashWithdrawProcess(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(ATMMachine atmMachine, double remainingAmount) {
        int remainingNotes = (int) (remainingAmount / FIVE_HUNDRED_NOTE);
        int balance = (int) (remainingAmount % FIVE_HUNDRED_NOTE);

        if(remainingNotes <= atmMachine.getNoOfFiveHundredNotes()){
            atmMachine.deductFiveHundredNotes(remainingNotes);
        }else {
            atmMachine.deductFiveHundredNotes(atmMachine.getNoOfFiveHundredNotes());
            balance = balance - (remainingNotes - atmMachine.getNoOfFiveHundredNotes()) * FIVE_HUNDRED_NOTE;
        }

        System.out.println("500 Notes: " + remainingNotes);
        System.out.println("Remaining balance: " + atmMachine.getBalance());

        if(balance !=0) super.withdraw(atmMachine, balance);
    }
}
