package interviewBasics.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class SortExample {
    public static void main(String[] args) {
        Emp satish = new Emp(1, "satish", 22);
        Emp chandu = new Emp(2,"Chandu",22);
        Emp abhishek = new Emp(3,"Abhishek",18);
        Emp prince = new Emp(4,"prince",20);

        ArrayList<Emp> list = new ArrayList<>();
        list.add(satish);
        list.add(prince);
        list.add(abhishek);
        list.add(chandu);
        list.forEach(i -> System.out.println(i.id+" " + i.age+" "+i.name));

        Collections.sort(list);
        list.forEach(i -> System.out.println(i.id+" " + i.age+" "+i.name));
    }
}
