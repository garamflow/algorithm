import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int dasom = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < N; i++) {
            pq.offer(sc.nextInt());
        }

        int count = 0;

        while (!pq.isEmpty() && dasom <= pq.peek()) {
            int vote = pq.poll();
            vote--;
            pq.offer(vote);
            dasom++;
            count++;
        }

        System.out.println(count);
        sc.close();
    }
}