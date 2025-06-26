package Employee;
import java.time.LocalDate;

public class Employee {
    private String name;
    private String department;
    private double salary;
    private LocalDate joiningDate;

    // Constructor
    public Employee(String name, String department, double salary, LocalDate joiningDate) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public LocalDate getJoiningDate() { return joiningDate; }

    @Override
    public String toString() {
        return name + " (" + department + ") - $" + salary + ", Joined: " + joiningDate;
    }
}
