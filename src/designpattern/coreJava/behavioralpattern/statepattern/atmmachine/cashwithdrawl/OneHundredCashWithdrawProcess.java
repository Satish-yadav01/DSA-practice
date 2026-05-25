package designpattern.coreJava.behavioralpattern.statepattern.atmmachine.cashwithdrawl;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.ATMMachine;

public class OneHundredCashWithdrawProcess extends CashWithdrawProcess{

    public static final int ONE_HUNDRED_NOTE = 100;
    public OneHundredCashWithdrawProcess(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(ATMMachine atmMachine, double remainingAmount) {
        int remainingNotes = (int) (remainingAmount / ONE_HUNDRED_NOTE);
        int balance = (int) (remainingAmount % ONE_HUNDRED_NOTE);

        if(remainingNotes <= atmMachine.getNoOfOneHundredNotes()){
            atmMachine.deductOneHundredNotes(remainingNotes);
        }else{
            atmMachine.deductOneHundredNotes(atmMachine.getNoOfOneHundredNotes());
            balance = balance - (remainingNotes - atmMachine.getNoOfOneHundredNotes()) * ONE_HUNDRED_NOTE;
        }

        System.out.println("100 Notes: " + remainingNotes);
        System.out.println("Remaining balance: " + atmMachine.getBalance());

        if(balance!=0) System.out.println("Something went wrong");
    }
}
