package designpattern.coreJava.behavioralpattern.statepattern.atmmachine.state;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.ATMMachine;
import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.cashwithdrawl.CashWithdrawProcess;
import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.cashwithdrawl.FiveHundredCashWithdrawProcess;
import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.cashwithdrawl.OneHundredCashWithdrawProcess;
import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.cashwithdrawl.TwoThousandCashWithdrawProcess;

public class CashWithdrawalState implements ATMState{

    private final CashWithdrawProcess cashWithdrawProcess;

    public CashWithdrawalState() {
        this.cashWithdrawProcess = new TwoThousandCashWithdrawProcess(
                new FiveHundredCashWithdrawProcess(
                        new OneHundredCashWithdrawProcess(null)
                )
        );
    }

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
        System.out.println("PIN already verified");
    }

    @Override
    public void withdrawCash(ATMMachine atm, int amount) {
        if (atm.getBalance() >= amount) {

            System.out.println("Dispensing cash: " + amount);

            atm.deductBalance(amount);
            cashWithdrawProcess.withdraw(atm, (double)amount);

            System.out.println("Remaining balance: " + atm.getBalance());

        } else {
            System.out.println("Insufficient balance");
        }
    }
}
