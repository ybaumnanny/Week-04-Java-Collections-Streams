import java.util.*;
public class QueueReversal{
    public static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();   
        // Dequeue all elements and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        // Pop from stack and enqueue back to queue (reversed order)
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
