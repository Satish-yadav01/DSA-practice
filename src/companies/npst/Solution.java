package companies.npst;

import java.util.*;

//class Dept {
//    public String name;
//    List<Emp> emp;
//}


class Emp {
    public String name;
    public Integer salary;

    public Emp(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
}

class IdComparator implements Comparator<Emp>{


    @Override
    public int compare(Emp o1, Emp o2) {
//        if(!o1.name.equalsIgnoreCase(o2.name)){
//            return o1.name.compareTo(o2.name) ;
//        } else if (o1.salary > o2.salary;) {
//            return o1.salary - o2.salary;
//        }

        return 1;
    }
}

public class Solution {
    public static void main(String[] args) {
        LinkedList<Emp> employees = new LinkedList<>();
        employees.add(new Emp("satish",50));
        employees.add(new Emp("abhishek",70));
        employees.add(new Emp("satish",80));

        Collections.sort(employees,new IdComparator());

        employees.stream().forEach(i-> System.out.print(i+" "));


    }
}
