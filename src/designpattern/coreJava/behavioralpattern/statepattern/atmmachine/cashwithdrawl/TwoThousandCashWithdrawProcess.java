package designpattern.coreJava.behavioralpattern.statepattern.atmmachine.cashwithdrawl;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.ATMMachine;

public class TwoThousandCashWithdrawProcess extends CashWithdrawProcess{

    public static final int TWO_THOUSAND_NOTE = 2000;

    public TwoThousandCashWithdrawProcess(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(ATMMachine atmMachine, double remainingAmount) {
        int remainingNotes = (int) (remainingAmount / TWO_THOUSAND_NOTE);
        int balance = (int) (remainingAmount % TWO_THOUSAND_NOTE);

        if(remainingNotes <= atmMachine.getNoOfTwoThousandNotes()){
            atmMachine.deductTwoThousandNotes(remainingNotes);
        } else {
            atmMachine.deductTwoThousandNotes(atmMachine.getNoOfTwoThousandNotes());
            balance = balance - (remainingNotes - atmMachine.getNoOfTwoThousandNotes()) * TWO_THOUSAND_NOTE;
        }

        System.out.println("2000 Notes: " + remainingNotes);
        System.out.println("Remaining balance: " + atmMachine.getBalance());

        if(balance !=0) super.withdraw(atmMachine, balance);
    }
}
