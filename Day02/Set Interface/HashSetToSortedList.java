import java.util.*;
public class HashSetToSortedList{
    public static <T extends Comparable<T>> List<T> convertAndSort(Set<T> set) {
        List<T> sortedList = new ArrayList<>(set); // Convert to list
        Collections.sort(sortedList);
        return sortedList;
    }
    public static void main(String[] args){
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> sortedList = convertAndSort(hashSet);
        System.out.println(sortedList); // output: [1, 3, 5, 9]
   }
}
