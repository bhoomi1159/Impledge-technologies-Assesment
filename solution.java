import java.io.*;   // provides input output reading   writing files functionality.
import java.nio.file.*; //used to get file paths.
import java.util.*; // it has all the classes for datastructures like hashmap,hashset, list,etc     

public class solution {
    public static boolean compoundword(String word, Set<String> wordSet, Map<String, Boolean> result) {
        if (result.containsKey(word)) {
            return result.get(word);
        }
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix)) {
                if (wordSet.contains(suffix) || compoundword(suffix, wordSet, result)) {
                    result.put(word, true);
                    return true;
                }
            }
        }

        // if no prefix found in hashset marks as false
        result.put(word, false);
        return false;
    }

    public static void checklongestCompoundWords(String filePath) throws IOException {
        // Start timing
        long startTime = System.nanoTime();

        // this can read the given input.text and stores in a list name words
        List<String> words = Files.readAllLines(Paths.get(filePath));
        // sort the words by length from smaller to larger
        Collections.sort(words, Comparator.comparingInt(String::length));
        // using a hashset and map for storing the results
        Set<String> wordSet = new HashSet<>(words);
        Map<String, Boolean> result = new HashMap<>();

        String longestWord = "";
        String secondLongestWord = "";

        for (String word : words) {
            wordSet.remove(word); // it remove word tempoaray for checking.
if (compoundword(word, wordSet, result)) {
                if (word.length() > longestWord.length()) {
                    secondLongestWord = longestWord;
                    longestWord = word;
                } else if (word.length() > secondLongestWord.length()) {
                    secondLongestWord = word;
                }
            }

            wordSet.add(word); // Add the word back to the set
        }

        // End timing
        long endTime = System.nanoTime();
        long Time = (endTime - startTime) / 1_000_000;
        // dividing with 1000000 convert nano to miiliseconds.
        // output having longest,second longest compound words with time
        System.out.println("Longest Compound Word: " + longestWord);
        System.out.println("Second Longest Compound Word: " + secondLongestWord);
        System.out.println("Time taken to process file " + filePath + ": " + Time + " milliseconds\n");
    }

    public static void main(String[] args) {
        try {
            // giving the input filess
            // checklongestCompoundWords("Input_01.txt");
            checklongestCompoundWords("Input_02.txt");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } // this try catch is use to handle if any io exception occurs
    }
}
