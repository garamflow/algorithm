import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine()); // 거점을 방문한 횟수


        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            
            if (A == 0) {
                if (pq.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                while(st.hasMoreTokens()) {
                    int value = Integer.parseInt(st.nextToken());
                    pq.add(value);
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}
