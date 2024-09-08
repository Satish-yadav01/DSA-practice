package interviewBasics.revision.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeSort {
    public static void main(String[] args) {
        Employee satish = new Employee(1, "satish", 22);
        Employee abhishek = new Employee(2,"abhishek",20);
        Employee chandu = new Employee(3,"chandu",22);
        Employee ashish = new Employee(4,"ashish",23);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(satish);
        employees.add(chandu);
        employees.add(abhishek);
        employees.add(ashish);
        employees.forEach(emp -> System.out.println(emp.getId()+" "+ emp.getAge()+" "+emp.getName()));
//        System.out.println(employees);
        System.out.println("---------------sorting---------------------");
        Collections.sort(employees);
        employees.forEach(emp -> System.out.println(emp.getId()+" "+ emp.getAge()+" "+emp.getName()));
    }
}
