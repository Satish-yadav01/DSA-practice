package designpattern.coreJava.behavioralpattern.strategypattern.payment.strategy;

public class UPIPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        System.out.println("Payment done using UPI with amount : "+ amount);
        return true;
    }
}
