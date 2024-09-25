import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push_front" -> {
                    int x = Integer.parseInt(st.nextToken());
                    deque.addFirst(x);
                }
                case "push_back" -> {
                    int x = Integer.parseInt(st.nextToken());
                    deque.addLast(x);
                }
                case "pop_front" -> {
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.getFirst());
                        deque.removeFirst();
                    }
                }
                case "pop_back" -> {
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.getLast());
                        deque.removeLast();
                    }
                }
                case "size" -> {
                    System.out.println(deque.size());
                }
                case "empty" -> {
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                }
                case "front" -> {
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.getFirst());
                    }
                }
                case "back" -> {
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(deque.getLast());
                    }
                }
            }
        }
    }
}