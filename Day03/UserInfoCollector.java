import java.io.*;
public class UserInfoCollector {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = null;
        try {
            // user information
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String favLanguage = reader.readLine();

            // Create and write to file
            writer = new FileWriter("D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Infocollector.txt");
            writer.write("User Information:\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + favLanguage + "\n");

            System.out.println("Information has been saved to user_info.txt");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}