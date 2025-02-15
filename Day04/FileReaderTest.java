import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        // Using try-with-resources to automatically close resources
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            // Reading and printing the first line
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println(firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) { // Handle file-related exceptions
            System.out.println("Error reading file");
        }
    }
}
