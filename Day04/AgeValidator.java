import java.util.Scanner;
class InvalidAgeException extends Exception {
    // Constructor to initialize the exception message
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking user input for age
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Calling the validateAge method
            validateAge(age);
        } catch (InvalidAgeException e) { // Handle custom exception
            System.out.println(e.getMessage());
        } catch (Exception e) { // Handle other unexpected exceptions
            System.out.println("Invalid input. Please enter a valid age.");
        } finally {
            scanner.close(); // Close scanner to prevent resource leak
        }
    }
}
