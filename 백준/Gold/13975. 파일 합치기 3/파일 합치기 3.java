import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcases; i++) {
            int length = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < length; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            Long sum = 0L;

            while (pq.size() > 1) {
                Long first = pq.poll();
                Long second = pq.poll();

                sum += first + second;
                pq.add(first + second);
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
