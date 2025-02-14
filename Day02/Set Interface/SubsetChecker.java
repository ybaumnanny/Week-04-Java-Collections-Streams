import java.util.*;
public class SubsetChecker {
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1);// Check if set2 contains all elements of set1
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(isSubset(set1, set2));// Output: true
    }
}
