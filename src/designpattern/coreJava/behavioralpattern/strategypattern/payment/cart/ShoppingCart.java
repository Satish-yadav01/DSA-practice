package designpattern.coreJava.behavioralpattern.strategypattern.payment.cart;

import designpattern.coreJava.behavioralpattern.strategypattern.payment.model.Product;
import designpattern.coreJava.behavioralpattern.strategypattern.payment.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> products;
    private final PaymentStrategy paymentStrategy;
    private double totalAmount;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.products = new ArrayList<>();
        this.paymentStrategy = paymentStrategy;
        this.totalAmount = 0.0;
    }

    public boolean addToCart(Product product){
        System.out.printf("Adding product %s to cart\n",product);
        try {
            this.products.add(product);
            totalAmount +=product.getPrice();
            return true;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage() + e);
            return false;
        }
    }

    public boolean removeFromCart(Product product){
        try {
            System.out.println("Removing from the Cart " + product);
            this.products.remove(product);
            totalAmount -=product.getPrice();
            return true;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage() + e);
            return false;
        }
    }

    public void checkout(){
        System.out.println("Checking out the cart");
        if(paymentStrategy.pay(totalAmount)){
            totalAmount = 0.0;
            System.out.println("\n!!!Amount has been paid successfully!!");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void displayAllProduct() {
        for(var product : products){
            System.out.println(product);
        }
    }
}
