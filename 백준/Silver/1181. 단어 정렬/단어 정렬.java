import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Word {
        String word;
        int length;

        public Word(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        // 길이가 짧은것부터
        // 길이가 같으면 사전순
        // 중복단어 제거
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int wordCount = Integer.parseInt(br.readLine());

        Set<Word> wordSet = new TreeSet<>((word1, word2) -> {
            if (word1.length != word2.length) {
                return Integer.compare(word1.length, word2.length);
            }
            return word1.word.compareTo(word2.word);
        });

        for (int i = 0; i < wordCount; i++) {
            String inputWord = br.readLine();
            wordSet.add(new Word(inputWord, inputWord.length()));
        }

        for (Word w: wordSet) {
            sb.append(w.word).append("\n");
        }

        System.out.println(sb);
    }
}
