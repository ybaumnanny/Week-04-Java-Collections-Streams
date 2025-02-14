import java.util.*;
public class BinaryNumberGenerator {
    public static <T extends Number> List<String> generateBinaryNumbers(T n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        if (n.intValue() <= 0) {
            return result; // Return an empty list for non-positive input
        }
        queue.offer("1"); // Start with "1"
        
        for (int i = 0; i < n.intValue(); i++) {
            String binary = queue.poll(); // Get the front element
            result.add(binary);
            
            // Generate next binary numbers and add them to the queue
            queue.offer(binary + "0");
            queue.offer(binary + "1");
        }
        return result;
    }    
    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers);
    }
}
