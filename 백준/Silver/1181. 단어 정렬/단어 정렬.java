import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int wordCount = Integer.parseInt(br.readLine());

        Set<String> wordSet = new TreeSet<>((firstWord, secondWord) -> {
            if (firstWord.length() != secondWord.length()) {
                return Integer.compare(firstWord.length(), secondWord.length());
            }
            return firstWord.compareTo(secondWord);
        });

        for (int i = 0; i < wordCount; i++) {
            String inputWord = br.readLine();
            wordSet.add(inputWord);
        }

        for (String w: wordSet) {
            sb.append(w).append("\n");
        }

        System.out.println(sb);
    }
}
