package designpattern.coreJava.behavioralpattern.statepattern.atmmachine;

public class Driver {
    public static void main(String[] args) {
        ATMMachine atm = new ATMMachine();
        atm.enterPin(1234);
        atm.insertCard();
        atm.withdrawCash(500);
        atm.enterPin(1234);
        atm.withdrawCash(500);
        atm.ejectCard();
        atm.withdrawCash(400);
    }
}
