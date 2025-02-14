import java.util.*;
public class SymmetricDifference {
    public static <T> Set<T> findSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        for (T element : set2) {
            // If result already contains the element, remove it, otherwise add it
            if (!result.add(element)) {
                result.remove(element);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> symmetricDiff = findSymmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}
