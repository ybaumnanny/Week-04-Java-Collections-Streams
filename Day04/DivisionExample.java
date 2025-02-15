import java.util.*;
public class DivisionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();
            
            // division
            int result = num1 / num2;
            
            // Print result if no exception occurs
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) { 
            System.out.println("ArithmeticException and thus cannot divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException Invalid input. Please enter numeric values only.");
        } finally {
            scanner.close(); // Close scanner
        }
    }
}
