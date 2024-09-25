import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Deque<Character> deque = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                if(!deque.isEmpty() && deque.getLast() == c) {
                    deque.removeLast();
                } else {
                    deque.addLast(c);
                }
            }

            if (deque.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}