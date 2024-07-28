package lld.atmv2.cashwithdraw;

import lld.atmv2.model.Atm;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class TwoThousandCashWithdrawProcess extends CashWithdrawProcess {
    public TwoThousandCashWithdrawProcess(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(Atm atm, double remainingAmount){
        int requiredAmount = (int) (remainingAmount / 2000);
        int balance = (int) (remainingAmount % 2000);

        if(requiredAmount <= atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(requiredAmount);
        } else if (requiredAmount > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance - (requiredAmount - atm.getNoOfTwoThousandNotes()) * 2000;
        }

        if (balance !=0){
            super.withdraw(atm, balance);
        }
    }
}
