
import java.util.*;

public class FindTheKeyWithTheHighestValue {

    public static void main(String[] args) {
        // Example map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Find the key with the highest value
        String keyWithMaxValue = findKeyWithMaxValue(map);

        // Output the result
        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }

    // Method to find the key with the highest value
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        // Initialize variables to track the maximum value and the associated key
        String keyWithMaxValue = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // Compare the current value with the max value
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                keyWithMaxValue = entry.getKey();
            }
        }

        // Return the key with the maximum value
        return keyWithMaxValue;
    }
}

