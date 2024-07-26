package lld.atmv2.constant;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public enum TransactionType {

    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes(){

        for(TransactionType type: TransactionType.values()){
            System.out.println(type.name());
        }
    }
}
