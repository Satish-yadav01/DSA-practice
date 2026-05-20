package designpattern.coreJava.behavioralpattern.strategypattern.payment.strategy;

public class CashPayment implements PaymentStrategy{

    @Override
    public boolean pay(double amount) {
        System.out.println("Payment Done by Cash with amount : " + amount);
        return true;
    }
}
