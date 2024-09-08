package interviewpreparingkit.ForRevision.java8.pradicate;

import java.util.List;
import java.util.function.Predicate;


public class Customer {
    private int id;
    private String name;
    private int age;

    public Customer(int id,String name, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    Predicate<Integer> isAdult = age -> age >= 18;
}


class CustomerExample{
    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer(1, "Satish", 22),
                new Customer(2, "Naman", 15),
                new Customer(3, "Abhishek", 26)
        );

        customers.forEach(c->{
            if(c.isAdult.test(c.getAge())){
                System.out.println(c.getName() + " is Adult");
            }else {
                System.out.println(c.getName() + " is not Adult");
            }
        });
    }
}