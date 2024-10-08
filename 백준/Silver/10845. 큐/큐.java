import java.util.*;
import java.io.*;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String command = br.readLine();
            sb.append(queueCommand(command)); // 처리 결과 StringBuilder에 추가
        }

        // 결과 출력
        System.out.println(sb.toString());
        br.close();
    }

    public static String queueCommand(String command) {
        StringTokenizer st = new StringTokenizer(command);
        String operation = st.nextToken();

        switch (operation) {
            case "push" -> {
                int value = Integer.parseInt(st.nextToken());
                queue.add(value);
                return "";
            }
            case "pop" -> {
                if(queue.isEmpty()) {
                    return "-1\n";
                } else {
                    return queue.poll() + "\n";
                }
            }
            case "size" -> {
                return queue.size() + "\n";
            }
            case "empty" -> {
                return (queue.isEmpty() ? 1 : 0) + "\n";
            }
            case "front" -> {
                if (queue.isEmpty()) {
                    return "-1\n";
                } else {
                    return queue.peek() + "\n";
                }
            }
            case "back" -> {
                if (queue.isEmpty()) {
                    return "-1\n";
                } else {
                    return ((LinkedList<Integer>) queue).getLast() + "\n";
                }
            }
            default -> {
                return "";
            }
        }
    }
}