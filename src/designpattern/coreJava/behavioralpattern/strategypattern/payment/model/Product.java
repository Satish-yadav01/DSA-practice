package designpattern.coreJava.behavioralpattern.strategypattern.payment.model;

import designpattern.coreJava.behavioralpattern.strategypattern.payment.data.Category;

public class Product {
    private final long id;
    private final String name;
    private final Category category;
    private final double price;

    public Product(long id, String name, Category category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    //use the builder pattern here to create a Product object and make immutable
    public static class Builder {
        private long id;
        private String name;
        private Category category;
        private double price;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
