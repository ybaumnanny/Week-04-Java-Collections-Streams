import java.io.*;
public class FileReaderExample {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "data.txt";

        // Try to read the file
        try {
            // FileReader and BufferedReader are used to read the file
            try (FileReader fileReader = new FileReader(fileName);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                
                // Read and print file content
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) { // Catch IOException
            System.out.println("File not found"); 
        }
    }
}
