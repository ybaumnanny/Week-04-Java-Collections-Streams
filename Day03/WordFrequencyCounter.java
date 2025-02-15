import java.io.*;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "D:\\CAPGEMINI\\Program Prerequisites\\CG Training clone\\WEEK 4\\Day03\\Input.txt"; // Specify the text file path
        Map<String, Integer> wordCountMap = new HashMap<>();// for storing the words

        // reading file and counting the word occurence
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Spliting the lines in words using regex
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) { // Ignore empty strings
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort by frequency

        // Display the total word count
        int totalWords = wordCountMap.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total words in file: " + totalWords);

        // Display the top 5 most frequent words
        System.out.println("\nTop 5 most frequently occurring words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " times");
            if (++count == 5) break; 
        }
    }
}

