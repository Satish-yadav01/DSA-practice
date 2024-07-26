package lld.atmv2.cashwithdraw;

import atmv2.model.Atm;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class OneHundredCashWithdrawProcess extends CashWithdrawProcess {
    public OneHundredCashWithdrawProcess(CashWithdrawProcess nextCashWithdrawProcess) {
        super(nextCashWithdrawProcess);
    }

    @Override
    public void withdraw(Atm atm, double remainingAmount){
        int requiredAmount = (int) (remainingAmount / 100);
        int balance = (int) (remainingAmount % 2000);

        if(requiredAmount <= atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(requiredAmount);
        } else if (requiredAmount > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance - (requiredAmount - atm.getNoOfTwoThousandNotes()) * 100;
        }

        if (balance !=0){
            System.out.println("Something went wrong");
        }
    }
}
