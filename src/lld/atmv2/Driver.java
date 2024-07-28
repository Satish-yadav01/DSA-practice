package lld.atmv2;

import lld.atmv2.constant.TransactionType;
import lld.atmv2.model.*;

import java.util.Scanner;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank icicBank = new Bank("ICIC-BANK");
        Card card = new Card("123456789", "satish", 2025, 12, 344);
        User satish = new User(1, "Satish", card);
        UserDetail satishDetail = new UserDetail("123456789", 1234, 10000);
        icicBank.setUserDetailByUser(satish, satishDetail);

        Atm atm = Atm.getInstance(icicBank);
        atm.setAtmBalance(500000, 500, 500, 2000);
        boolean isTrue = true;

        while (isTrue) {
            atm.getAtmState().insertCard(atm);
            User user = atm.getAtmState().authenticatePin(atm);
            if (user != null) {
                atm.getAtmState().selectOperation(atm, TransactionType.CASH_WITHDRAWAL);
                atm.getAtmState().cashWithdrawal(atm, user, 3700);
                atm.printCurrentATMStatus();
                atm.getAtmState().displayBalance(atm, user);

            }else {
                System.out.println("User not found,Please try again");
                isTrue = false;
            }

            System.out.println("Wanted to exit [Y/N]");
            char exit = scanner.nextLine().toUpperCase().trim().charAt(0);

            if(exit == 'Y'){
                isTrue = false;
            }
        }

    }
}
