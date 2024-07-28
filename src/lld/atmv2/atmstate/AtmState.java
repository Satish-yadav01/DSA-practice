package lld.atmv2.atmstate;

import lld.atmv2.constant.TransactionType;
import lld.atmv2.model.Atm;
import lld.atmv2.model.User;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public abstract class AtmState {
    public void insertCard(Atm atm) {
        System.out.println("Oops something went wrong");
    }

    public User authenticatePin(Atm atm) {
        System.out.println("Oops something went wrong");
        return null;
    }

    public void selectOperation(Atm atm, TransactionType transactionType) {
        System.out.println("Oops something went wrong");
    }

    public void cashWithdrawal(Atm atm,User user, int withdrawAmount) {
        System.out.println("Oops something went wrong");
    }

    public void displayBalance(Atm atm,User user) {
        System.out.println("Oops something went wrong");
    }

    public void returnCard() {
        System.out.println("Oops something went wrong");
    }

    public void exit(Atm atm) {
        System.out.println("Oops something went wrong");
    }
}
