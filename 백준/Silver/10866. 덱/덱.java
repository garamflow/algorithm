import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  // 출력 최적화
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
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.removeFirst() + "\n");
                    }
                }
                case "pop_back" -> {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.removeLast() + "\n");
                    }
                }
                case "size" -> bw.write(deque.size() + "\n");
                case "empty" -> {
                    if (deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                }
                case "front" -> {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.getFirst() + "\n");
                    }
                }
                case "back" -> {
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.getLast() + "\n");
                    }
                }
            }
        }
        bw.flush();  // 모든 출력이 완료된 후 flush
        bw.close();
    }
}
