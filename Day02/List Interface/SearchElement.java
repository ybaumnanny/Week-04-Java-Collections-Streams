import java.util.LinkedList;
public class SearchElement {
    // Method to find the Nth element from the end using two pointers
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0 || n > list.size()) {
            return null; // Invalid case if n is out of bounds
        }

        // Initialize two pointers: fast and slow
        T slow = null, fast = null;
        int index = 0;

        // Create a new LinkedList for traversal
        LinkedList<T> tempList = new LinkedList<>(list);

        // Move the fast pointer N steps ahead
        while (index < n) {
            fast = tempList.poll(); // Move fast pointer N steps ahead
            index++;
        }

        // Now move both fast and slow one step at a time
        while (!tempList.isEmpty()) {
            slow = fast;
            fast = tempList.poll();
        }

        return slow;
    }
}