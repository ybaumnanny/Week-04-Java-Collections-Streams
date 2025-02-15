import java.io.*;
public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "Studentdata.txt"; // Binary file to store student details

        // read and write student details to the file
        writeStudentData(fileName);
        readStudentData(fileName);
    }
    private static void writeStudentData(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Writing multiple student records
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Yaman Mahtha"); // Name
            dos.writeDouble(3.8); // GPA

            dos.writeInt(102);
            dos.writeUTF("Mohit Soni Smith");
            dos.writeDouble(3.5);

            dos.writeInt(103);
            dos.writeUTF("Vidhi Jain Brown");
            dos.writeDouble(3.9);

            System.out.println("Student details successfully written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading student details from " + fileName + ":");
            while (dis.available() > 0) { // Check if there is data left to read
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}

