import java.io.*;
public class UpperToLowerFileConverter {
    public static void main(String[] args) {
        // Define input and output file names
        String inputFile = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\upperlower.txt";  
        String outputFile = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Temp_Outputlower.txt"; // Temporary output file

        // Use try-with-resources to handle file operations safely
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase and write to the temporary file
                writer.write(line.toLowerCase());
                writer.newLine(); // Add a new line after writing each line
            }
            System.out.println("File conversion completed. Check " + outputFile);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            return;
        }

        // Rename the temp output file to the original file
        File originalFile = new File(inputFile);
        File tempFile = new File(outputFile);

        if (originalFile.delete() && tempFile.renameTo(originalFile)) {
            System.out.println("File successfully converted and replaced: " + inputFile);
        } else {
            System.err.println("Error: Could not replace the original file.");
        }
    }
}
