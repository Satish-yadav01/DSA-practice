package lld.atmv2.atmstate;

import lld.atmv2.cashwithdraw.FiveHundredCashWithdrawProcess;
import lld.atmv2.cashwithdraw.CashWithdrawProcess;
import lld.atmv2.cashwithdraw.OneHundredCashWithdrawProcess;
import lld.atmv2.cashwithdraw.TwoThousandCashWithdrawProcess;
import lld.atmv2.model.Atm;
import lld.atmv2.model.User;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class CashWithdrawalState extends AtmState{

    private final CashWithdrawProcess cashWithdrawProcess;

    public CashWithdrawalState() {
        this.cashWithdrawProcess = new TwoThousandCashWithdrawProcess(new FiveHundredCashWithdrawProcess(new OneHundredCashWithdrawProcess(null)));
    }

    @Override
    public void cashWithdrawal(Atm atm, User user, int withdrawAmount) {
        System.out.println("------cash withdrawal in process--------");
        if(atm.getBank().getDetails().get(user).getBalance() <= withdrawAmount){
            System.out.println("Insufficient balance in your account");
            exit(atm);
            return;
        }
        if (atm.getAtmBalance() < withdrawAmount){
            System.out.println("Insufficient balance in ATM");
            exit(atm);
            return;
        }
        atm.deductATMBalance(withdrawAmount);
        atm.deductUserBalance(user,withdrawAmount);
        cashWithdrawProcess.withdraw(atm,withdrawAmount);
        atm.setAtmState(new CheckBalanceState());
    }

    @Override
    public void returnCard() {
        System.out.println("please collect your card");
    }

    @Override
    public void exit(Atm atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }
}
