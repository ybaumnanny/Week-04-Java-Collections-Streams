import java.util.*;
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public abstract String getRoleDescription();
}
// Concrete job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }
    @Override
    public String getRoleDescription() {
        return "Software Engineer Role: Requires programming skills, algorithms, and system design.";
    }
}
class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }
    @Override
    public String getRoleDescription() {
        return "Data Scientist Role: Requires machine learning, data analysis, and statistical modeling.";
    }
}
class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }
    @Override
    public String getRoleDescription() {
        return "Product Manager Role: Requires business acumen, strategic thinking, and stakeholder management.";
    }
}
// Generic class
class Resume<T extends JobRole> {
    private T candidate;

    public Resume(T candidate) {
        this.candidate = candidate;
    }

    public void displayResumeDetails() {
        System.out.println("Candidate: " + candidate.getCandidateName());
        System.out.println(candidate.getRoleDescription());
    }
}

// Utility claas
class ResumeScreeningUtility {
    private ResumeScreeningUtility() {} // Private constructor to prevent instantiation

    // Generic method for screening resumes
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("Screening Resume...");
        resume.displayResumeDetails();
        System.out.println("Resume passed initial screening.\n");
    }

    // Wildcard method used
    public static void processMultipleResumes(List<? extends JobRole> resumes) {
        System.out.println("Processing multiple resumes...");
        for (JobRole role : resumes) {
            System.out.println("Candidate: " + role.getCandidateName());
            System.out.println(role.getRoleDescription());
        }
    }
}
// Main class 
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Creating resumes for different job roles
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie"));

        // Screening individual resumes
        ResumeScreeningUtility.screenResume(seResume);
        ResumeScreeningUtility.screenResume(dsResume);
        ResumeScreeningUtility.screenResume(pmResume);

        // Processing multiple resumes using wildcards
        List<JobRole> jobRoles = Arrays.asList(
            new SoftwareEngineer("David"),
            new DataScientist("Emma"),
            new ProductManager("Frank")
        );
        
        ResumeScreeningUtility.processMultipleResumes(jobRoles);
    }
}
