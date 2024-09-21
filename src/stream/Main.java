package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1, "satish", 1000),
                new Employee(2, "prabhakar", 1300),
                new Employee(3, "naman", 900)
        ));

        Integer salary = employees.stream()
                .map(employee -> employee.salary)
                .sorted()
                .toList()
                .get(employees.size() - 2);

        System.out.println(salary);

        Employee secHighestSalariedEmployee = employees.stream()
                .sorted(Comparator.comparing(employee -> employee.salary))
                .toList()
                .get(employees.size() - 2);

        System.out.println(secHighestSalariedEmployee.name + " " + secHighestSalariedEmployee.salary);

//        System.out.println(employees);
//
//        employees.sort(Comparator.comparing(employee -> employee.salary));
//
//        System.out.println(employees);
//
//        Employee employee = employees.get(employees.size() - 2);
//        System.out.println(employee.name);
    }

    static class Employee {
        int id;
        String name;
        int salary;


        public Employee(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }
}
