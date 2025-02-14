
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class GroupObjectsByProperty {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();

        for (Employee employee : employees) {
            employeesByDepartment
                    .computeIfAbsent(employee.department, k -> new ArrayList<>())
                    .add(employee);
        }

        employeesByDepartment.forEach((department, empList) -> {
            System.out.println(department + ": " + empList);
        });
    }
}
