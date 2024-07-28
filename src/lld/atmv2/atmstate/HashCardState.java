package lld.atmv2.atmstate;

import lld.atmv2.model.*;

import java.util.Map;
import java.util.Scanner;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class HashCardState extends AtmState {

    private User activeUser;

    public HashCardState() {
        this.activeUser = null;
    }

    @Override
    public User authenticatePin(Atm atm) {
        System.out.println("-----------Authenticating pin------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your card no : ");
        String card = scanner.next().trim();
        System.out.println("Please enter your card Pin : ");
        int pin = scanner.nextInt();

        boolean isAuthenticated = false;
        Map<User, UserDetail> details = atm.getBank().getDetails();
        for (Map.Entry<User, UserDetail> entry : details.entrySet()) {
            UserDetail userDetail = entry.getValue();
            User user = entry.getKey();
            if (user.getCard().getNumber().equals(card)) {
                activeUser = user;
            }
            if (userDetail.getCardNo().equals(card) && userDetail.getPin() == pin) {
                isAuthenticated = true;
                break;
            }
        }
        if (isAuthenticated) {
            System.out.println("Card authenticated, please proceed further");
            atm.setAtmState(new SelectOperationState());
        } else {
            System.out.println("Card not authenticated,please check again");
            exit(atm);
            return null;
        }
        return activeUser;
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
