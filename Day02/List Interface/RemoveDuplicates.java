import java.util.*;
public class RemoveDuplicates{
 public static<T> void RemoveDuplicates(List<T> List){
    Set<T> set = new LinkedHashSet<>(List);
}
public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3,1,2,2,4,2,3,1,2,3,1,2,3,4,2,6,4,5,3,3,9,9,8,4);
    List<Integer> uniqueNumbers = new ArrayList<>(new LinkedHashSet<>(numbers));
    System.out.println(uniqueNumbers); 
}
}