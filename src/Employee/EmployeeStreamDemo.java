package Employee;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Devavrat Upadhyay", "IT", 70000, LocalDate.of(2015, 3, 1)),
                new Employee("Lali", "HR", 50000, LocalDate.of(2016, 7, 10)),
                new Employee("Ram", "IT", 120000, LocalDate.of(2012, 1, 15)),
                new Employee("David", "Finance", 90000, LocalDate.of(2018, 6, 30)),
                new Employee("Eve", "IT", 110000, LocalDate.of(2019, 8, 21)),
                new Employee("Frank", "HR", 45000, LocalDate.of(2017, 11, 5))
        );

        // 1. Filter employees who belong to the “IT” department
        List<Employee> itEmployees = employees.stream()
                .filter(e -> "IT".equalsIgnoreCase(e.getDepartment()))
                .collect(Collectors.toList());
        System.out.println("Employees in IT Department:");
        itEmployees.forEach(System.out::println);

        // 2. Find the highest-paid employee
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaid.ifPresent(e -> {
            System.out.println("\nHighest Paid Employee:");
            System.out.println(e);
        });

        // 3. Group employees by department
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\nEmployees Grouped by Department:");
        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + ":");
            empList.forEach(e -> System.out.println("  " + e));
        });

        // 4. Sort employees by salary
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("\nEmployees Sorted by Salary:");
        sortedBySalary.forEach(System.out::println);

        // 5. Collect employee names into a list
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("\nEmployee Names:");
        employeeNames.forEach(System.out::println);
    }

    }

