import java.util.*;
class StackUsingQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;
    // Constructor for queue initialization
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(T item) {// Push the item to queue2
        queue2.offer(item);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());// Move all elements from queue1 to queue2
        }
        // Swap queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    public T pop() {// Pop the top element from queue1
        return queue1.poll();
    }
    
    public T top() {// Return the top element from queue1
        return queue1.peek();
    }
    
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackImplementation {
    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();// Create a stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack.pop()); 
        System.out.println(stack.top()); 
        System.out.println(stack.isEmpty()); 
    }
}