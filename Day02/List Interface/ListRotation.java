import java.util.*;
public class ListRotation {
    public static void rotate(List<Integer> list, int positions) {// method to create a list
        Collections.rotate(list, -positions);
    }
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;
        // Rotate the list by 2 positions
        rotate(numbers, rotateBy);
        System.out.println(numbers);
    }
}