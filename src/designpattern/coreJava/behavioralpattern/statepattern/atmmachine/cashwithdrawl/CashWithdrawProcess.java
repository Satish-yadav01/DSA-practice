package designpattern.coreJava.behavioralpattern.statepattern.atmmachine.cashwithdrawl;

import designpattern.coreJava.behavioralpattern.statepattern.atmmachine.ATMMachine;

public abstract class CashWithdrawProcess {

    private final CashWithdrawProcess nextCashWithdrawProcess;

    protected CashWithdrawProcess(CashWithdrawProcess nextCashWithdrawProcess) {
        this.nextCashWithdrawProcess = nextCashWithdrawProcess;
    }

    public void withdraw(ATMMachine atmMachine, double remainingAmount){
        if(nextCashWithdrawProcess != null){
            nextCashWithdrawProcess.withdraw(atmMachine,remainingAmount);
        }
    }
}
