import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 버튼 누른 횟수와 그 횟수에 맞게 Deque 구현
        // linkedList는 최근에 앞에 저장했는지 뒤에 저장했는지를 기록하는 역할
        int N = Integer.parseInt(st.nextToken());
        Deque<String> deque = new ArrayDeque<>();
        Deque<String> memory = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if (x == 1) {
                deque.addLast(st.nextToken());
                memory.addLast("last");
            } else if (x == 2) {
                deque.addFirst(st.nextToken());
                memory.addLast("first");
            } else if (x == 3) {
                if (!memory.isEmpty()) {
                    if (memory.removeLast().equals("last")) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }
        }

        if(deque.isEmpty()){
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : deque) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
}