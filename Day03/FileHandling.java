import java.io.*;
public class FileHandling {
    public static void main(String[] args) {
        String sourceFile = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Input.txt";
        String destinationFile = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Output.txt"; // Change destination file

        // Try-with-resources to handle file streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            // Read from input file and write to output file
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File read successfully and copied to Output.txt");     
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
