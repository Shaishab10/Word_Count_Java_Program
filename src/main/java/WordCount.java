import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WordCount {
    public static void main(String[] args)  {

        HashMap<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        List<String> sortedWords = new ArrayList<>(wordCount.keySet());
        Collections.sort(sortedWords);


        for (String word : sortedWords) {
            System.out.println(word + ": " + wordCount.get(word));
        }
    }

}
