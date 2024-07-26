package lld.atmv2.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class UserDetail {
    private String cardNo;
    private int pin;
    private double balance;

    public UserDetail(String cardNo, int pin, double balance) {
        this.cardNo = cardNo;
        this.pin = pin;
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
