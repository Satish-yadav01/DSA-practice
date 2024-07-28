package lld.atmv2.cashwithdraw;

import lld.atmv2.model.Atm;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public abstract class CashWithdrawProcess {

    private CashWithdrawProcess nextCashWithdrawProcess;

    public CashWithdrawProcess(CashWithdrawProcess nextCashWithdrawProcess) {
        this.nextCashWithdrawProcess = nextCashWithdrawProcess;
    }

    public void withdraw(Atm atm, double remainingAmount){
        if(nextCashWithdrawProcess != null){
            nextCashWithdrawProcess.withdraw(atm,remainingAmount);
        }
    }
}
