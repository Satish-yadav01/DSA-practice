package lld.atmv2.atmstate;

import lld.atmv2.constant.TransactionType;
import lld.atmv2.model.Atm;


/**
 * @author : Satish Yadav
 * @purpose :
 */
public class SelectOperationState extends AtmState{

    public SelectOperationState() {
        showOperations();
    }

    @Override
    public void selectOperation(Atm atm,TransactionType transactionType) {
        switch (transactionType){
            case TransactionType.BALANCE_CHECK -> {
                System.out.println("You have chosen to balance check");
                atm.setAtmState(new CheckBalanceState());
            }
            case TransactionType.CASH_WITHDRAWAL -> {
                System.out.println("You have chosen to cash withdrawal");
                atm.setAtmState(new CashWithdrawalState());
            }
            default -> {
                System.out.println("Not matching TransactionType");
                exit(atm);
            }
        }
    }

    private void showOperations() {
        System.out.println("-----Show Atm Operations-----");
        TransactionType.showAllTransactionTypes();
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
