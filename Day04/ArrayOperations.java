import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner is NOT closed
        
        try {
            // Example: remove commnent from the next line to test NullPointerException
            // int[] arr = null;
            
            // Initializing an integer array (Modify values as needed)
            int[] arr = {10, 20, 30, 40, 50};

            // Asking user for index input
            System.out.print("Enter the index: ");
            int index = scanner.nextInt();

            // Retrieving and printing value at the given index
            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) { // Handle invalid index access
            System.out.println("Invalid index!");
        } catch (NullPointerException e) { // Handle null array access
            System.out.println("Array is not initialized!");
        } catch (Exception e) { // Handle other unexpected exceptions
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}
