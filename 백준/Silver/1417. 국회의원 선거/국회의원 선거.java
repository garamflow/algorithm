import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 1; i < N; i++) {
            pq.offer(-Integer.parseInt(br.readLine()));
        }
        
        int count = 0;
        
        while (!pq.isEmpty() && dasom <= -pq.peek()) {
            int vote = -pq.poll();
            vote--;
            pq.offer(-vote);
            dasom++;
            count++;
        }
        
        System.out.println(count);
        br.close();
    }
}
