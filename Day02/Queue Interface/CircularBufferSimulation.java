class CircularBuffer<T> {
    private T[] buffer;
    private int size;
    private int front;
    private int rear;
    private int count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = (T[]) new Object[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    // Insert element to the buffer
    public void insert(T element) {
        if (count == size) {
            // Buffer is full, overwrite the oldest element
            front = (front + 1) % size;  // Move front to the next element
        } else {
            count++;
        }
        buffer[rear] = element;
        rear = (rear + 1) % size;  // Move rear to the next position
    }

    // Remove and return the front element
    public T remove() {
        if (count == 0) {
            throw new IllegalStateException("Buffer is empty");
        }
        T removedElement = buffer[front];
        front = (front + 1) % size;  // Move front to the next position
        count--;
        return removedElement;
    }

    // Get the element at the front without removing it
    public T peek() {
        if (count == 0) {
            throw new IllegalStateException("Buffer is empty");
        }
        return buffer[front];
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if the buffer is full
    public boolean isFull() {
        return count == size;
    }

    // Display buffer contents (for debugging)
    public void display() {
        if (count == 0) {
            System.out.println("Buffer is empty");
            return;
        }
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size]);
            if (i != count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

public class CircularBufferSimulation {
    public static void main(String[] args) {
        // Create a circular buffer with size 3
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        // Insert elements
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display(); // Buffer: [1, 2, 3]

        // Insert another element, which will overwrite the oldest element
        buffer.insert(4);
        buffer.display(); // Buffer: [2, 3, 4]

        // Remove an element
        System.out.println("Removed: " + buffer.remove()); // Removed: 2
        buffer.display(); // Buffer: [3, 4]

        // Peek the front element
        System.out.println("Front element: " + buffer.peek()); // Front element: 3

        // Insert another element
        buffer.insert(5);
        buffer.display(); // Buffer: [3, 4, 5]

        // Remove and display the buffer
        System.out.println("Removed: " + buffer.remove()); // Removed: 3
        buffer.display(); // Buffer: [4, 5]
    }
}