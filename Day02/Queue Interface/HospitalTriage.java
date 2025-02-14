import java.util.*;
class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        //PriorityQueue with custom comparator to sort by severity (higher first)
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> -p.severity));

        //Adding patients
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        //Processing patients in order of severity
        System.out.println("Order of treatment:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}