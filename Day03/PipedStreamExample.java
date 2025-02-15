import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            // Convert message to bytes and write to the pipe
            pos.write(message.getBytes());
            System.out.println("WriterThread: Data written to the pipe.");
        } catch (IOException e) {
            System.err.println("WriterThread Error: " + e.getMessage());
        } finally {
            try {
                pos.close(); // Close the stream after writing
            } catch (IOException e) {
                System.err.println("Error closing PipedOutputStream: " + e.getMessage());
            }
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024]; // Buffer to store read data
            int bytesRead = pis.read(buffer); // Read data from the pipe
            String receivedMessage = new String(buffer, 0, bytesRead); // Convert bytes to String
            System.out.println("ReaderThread: Received -> " + receivedMessage);
        } catch (IOException e) {
            System.err.println("ReaderThread Error: " + e.getMessage());
        } finally {
            try {
                pis.close(); // Close the stream after reading
            } catch (IOException e) {
                System.err.println("Error closing PipedInputStream: " + e.getMessage());
            }
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect streams

            // Create and start threads
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            // Ensure threads complete execution before exiting main method
            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            System.err.println("Main Thread Error: " + e.getMessage());
        }
    }
}

