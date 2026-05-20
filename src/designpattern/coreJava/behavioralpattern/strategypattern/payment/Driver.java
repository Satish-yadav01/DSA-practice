package designpattern.coreJava.behavioralpattern.strategypattern.payment;

import designpattern.coreJava.behavioralpattern.strategypattern.payment.cart.ShoppingCart;
import designpattern.coreJava.behavioralpattern.strategypattern.payment.data.Category;
import designpattern.coreJava.behavioralpattern.strategypattern.payment.model.Product;
import designpattern.coreJava.behavioralpattern.strategypattern.payment.strategy.CashPayment;
import designpattern.coreJava.behavioralpattern.strategypattern.payment.strategy.UPIPayment;

public class Driver {
    public static void main(String[] args) {
        Product apple = new Product.Builder()
                .id(1)
                .name("Apple")
                .category(Category.FROZEN_FOOD)
                .price(50.0)
                .build();

        Product banana = new Product.Builder()
                .id(2)
                .name("Banana")
                .category(Category.FROZEN_FOOD)
                .price(20.0)
                .build();

        Product mango = new Product.Builder()
                .id(2)
                .name("Mango")
                .category(Category.FROZEN_FOOD)
                .price(30.0)
                .build();

        ShoppingCart shoppingCart = new ShoppingCart(new CashPayment());
        shoppingCart.addToCart(apple);
        shoppingCart.addToCart(banana);
        shoppingCart.addToCart(mango);

        shoppingCart.removeFromCart(mango);

        shoppingCart.displayAllProduct();

        System.out.println(shoppingCart.getTotalAmount());

        shoppingCart.checkout();

        System.out.println(shoppingCart.getTotalAmount());



    }
}
