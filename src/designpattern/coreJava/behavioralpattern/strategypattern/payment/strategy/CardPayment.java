package designpattern.coreJava.behavioralpattern.strategypattern.payment.strategy;

public class CardPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Payment done by Card with amount : " + amount);
        return true;
    }
}
