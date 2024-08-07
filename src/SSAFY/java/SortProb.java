package SSAFY.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortProb {
    public static void main(String[] args) {

        Employee[] emps = {
                new Employee("5", "설한결", "no.1", 5000),
                new Employee("2", "남궁소라", "no.2", 3000),
                new Employee("3", "오버들", "no.3", 1000),
                new Employee("1", "탁아람", "no.3", 1000),
                new Employee("7", "권철", "no.4", 500),
                new Employee("4", "유바다", "no.4", 500),
                new Employee("6", "풍우람", "no.4", 500),
        };

        Arrays.sort(emps);
        for (Employee emp : emps) {
            System.out.println(emp);
        }
        System.out.println();
        System.out.println();
        Arrays.sort(emps, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getEn().compareTo(o1.getEn());
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
        System.out.println();
        System.out.println();


        Arrays.sort(emps, (o1, o2) -> o1.getLevel().compareTo(o2.getLevel()));

        for (Employee emp : emps) {
            System.out.println(emp);
        }
        System.out.println();
        System.out.println();

        Arrays.sort(emps, (o1, o2) -> Integer.compare(o2.getSalary(), o1.getSalary()));

        for (Employee emp : emps) {
            System.out.println(emp);
        }
        System.out.println();
        System.out.println();

        List<Employee> list = Arrays.asList(emps);
        Collections.sort(list);

        for (Employee emp : list) {
            System.out.println(emp);
        }
        System.out.println();
        System.out.println();
    }
}
