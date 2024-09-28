import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                if(pq.isEmpty()){
                    res.append('0').append('\n');
                } else {
                    res.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(num);
            }
        }

        System.out.println(res.toString());
    }
}
