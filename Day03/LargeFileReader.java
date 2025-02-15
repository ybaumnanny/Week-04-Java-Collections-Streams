import java.io.*;
public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Input.txt"; // Specify the large file path

        // Use try-with-resources to ensure automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Lines containing 'error':\n");

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Check if the line contains "error" (case insensitive)
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            // Handle file-related exceptions
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}

