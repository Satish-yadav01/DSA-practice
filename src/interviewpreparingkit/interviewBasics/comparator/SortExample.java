package interviewpreparingkit.interviewBasics.comparator;



import interviewpreparingkit.interviewBasics.comparable.Emp;

import java.util.ArrayList;
import java.util.Collections;

public class SortExample {
    public static void main(String[] args) {
        interviewpreparingkit.interviewBasics.comparator.Emp satish = new interviewpreparingkit.interviewBasics.comparator.Emp(1, "satish", 22);
        interviewpreparingkit.interviewBasics.comparator.Emp chandu = new interviewpreparingkit.interviewBasics.comparator.Emp(2,"Chandu",22);
        interviewpreparingkit.interviewBasics.comparator.Emp abhishek = new interviewpreparingkit.interviewBasics.comparator.Emp(3,"Abhishek",18);
        interviewpreparingkit.interviewBasics.comparator.Emp prince = new interviewpreparingkit.interviewBasics.comparator.Emp(4,"prince",20);

        ArrayList<interviewpreparingkit.interviewBasics.comparator.Emp> list = new ArrayList<>();
        list.add(satish);
        list.add(abhishek);
        list.add(chandu);
        list.add(prince);

        list.forEach(i -> System.out.println(i.id+" " + i.age+" "+i.name));

        System.out.println("After sorting");

        Collections.sort(list,new NameComparator());

        list.forEach(i -> System.out.println(i.id+" " + i.age+" "+i.name));


    }
}
