import java.util.ArrayList;
import java.util.List;
abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }

    @Override
    public String toString() {
        return courseName + " (Instructor: " + instructor + ")";
    }
}
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }
}

// Generic class
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Courses Offered:");
        for (T course : courses) {
            System.out.println(course);
        }
    }

    // Wildcard method to display 
    public static void displayAllCourses(List<? extends CourseType> courseList) {
        System.out.println("All Courses:");
        for (CourseType course : courseList) {
            System.out.println(course);
        }
    }
}
// Main class 
public class UniversityCourseManagement{
    public static void main(String[] args) {
        // Creating course categories
        Course<ExamCourse> examCourseList = new Course<>();
        Course<AssignmentCourse> assignmentCourseList = new Course<>();
        Course<ResearchCourse> researchCourseList = new Course<>();

        // Adding courses
        ExamCourse examCourse1 = new ExamCourse("Data Structures", "Prof. Rajiv abstract");
        AssignmentCourse assignmentCourse1 = new AssignmentCourse("Software Engineering", "Prof. Jay Prakash");
        ResearchCourse researchCourse1 = new ResearchCourse("AI Research", "Dr. Kiran Pandey");

        examCourseList.addCourse(examCourse1);
        assignmentCourseList.addCourse(assignmentCourse1);
        researchCourseList.addCourse(researchCourse1);

        // Display courses by category
        examCourseList.displayCourses();
        assignmentCourseList.displayCourses();
        researchCourseList.displayCourses();

        // Using wildcard to display all courses dynamically
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(examCourse1);
        allCourses.add(assignmentCourse1);
        allCourses.add(researchCourse1);

        Course.displayAllCourses(allCourses);
    }
}
