import java.io.*;
import java.util.*;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +"id=" + id +", name='" + name + '\'' +", department='" + department + '\'' +",salary=" + salary +'}';
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Serialization.txt";

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public static List<Employee> loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Vidhi Jain","IT", 75000));
        employees.add(new Employee(2, "Sakshi Sharma", "HR", 96000));
        employees.add(new Employee(3, "Pranjal Hanswani", "Finance", 72000));

        saveEmployees(employees);

        List<Employee> retrievedEmployees = loadEmployees();
        retrievedEmployees.forEach(System.out::println);
    }
}
