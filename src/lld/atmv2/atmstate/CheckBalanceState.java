package lld.atmv2.atmstate;

import lld.atmv2.model.Atm;
import lld.atmv2.model.User;
import lld.atmv2.model.UserDetail;

import java.util.Map;


/**
 * @author : Satish Yadav
 * @purpose :
 */
public class CheckBalanceState extends AtmState{

    @Override
    public void displayBalance(Atm atm,User user) {
        System.out.println("Displaying balance...");
        Map<User, UserDetail> details = atm.getBank().getDetails();
        for (Map.Entry<User, UserDetail> entry : details.entrySet()) {
            if(entry.getKey() == user){
                System.out.println(entry.getKey().getName()+"'s Available Balance: "+entry.getValue().getBalance());
                return;
            }
        }
        System.out.println("User not found");
        exit(atm);
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
