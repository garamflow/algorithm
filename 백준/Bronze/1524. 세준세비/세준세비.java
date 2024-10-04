import java.io.*;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcases; i++) {
            PriorityQueue<Integer> sejunPriorityQueue = new PriorityQueue<>();
            PriorityQueue<Integer> sebiPriorityQueue = new PriorityQueue<>();

            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sejunCount = Integer.parseInt(st.nextToken());
            int sebiCount = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sejunCount; j++) {
                sejunPriorityQueue.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < sebiCount; j++) {
                sebiPriorityQueue.add(Integer.parseInt(st.nextToken()));
            }

            while(!sejunPriorityQueue.isEmpty() && !sebiPriorityQueue.isEmpty()) {
                if (Objects.equals(sejunPriorityQueue.peek(), sebiPriorityQueue.peek())) {
                    sebiPriorityQueue.poll();
                } else if (sejunPriorityQueue.peek() < sebiPriorityQueue.peek()) {
                    sejunPriorityQueue.poll();
                } else {
                    sebiPriorityQueue.poll();
                }
            }

            if(sejunPriorityQueue.isEmpty() && !sebiPriorityQueue.isEmpty()){
                bw.write("B");
            } else if (!sejunPriorityQueue.isEmpty() && sebiPriorityQueue.isEmpty()) {
                bw.write("S");
            } else {
                bw.write("C");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
