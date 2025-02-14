import java.util.*;
public class ListReversal {
    // Method to reverse an ArrayList
    public static void reverseArrayList(List<Integer> list) {
        int start = 0, end = list.size() - 1;
        while (start < end) {
            // Swap elements
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
    // Method to reverse a LinkedList 
    public static void reverseLinkedList(LinkedList<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        //  for ArrayList
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Array List Reversal :");
        System.out.println("Original ArrayList:- " + arrayList);
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList:- " + arrayList);
        // for LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Linked List Reversal :");
        System.out.println("\nOriginal LinkedList:- " + linkedList);
        reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList:- " + linkedList);
    }
}
