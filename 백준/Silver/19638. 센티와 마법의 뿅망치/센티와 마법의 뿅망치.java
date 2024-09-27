import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int population = Integer.parseInt(st.nextToken());
        int centiHeight = Integer.parseInt(st.nextToken());
        int magicLimit = Integer.parseInt(st.nextToken());
        int usedMagic = 0;

        PriorityQueue<Integer> giants = new PriorityQueue<>();
        for (int i = 0; i < population; i++) {
            giants.offer(-Integer.parseInt(br.readLine()));
        }

        while (!giants.isEmpty() && -giants.peek() >= centiHeight && magicLimit > 0) {
            int tallestGiant = -giants.poll();

            if (tallestGiant == 1) {
                giants.offer(-1);
                break;
            }

            int newHeight = tallestGiant / 2;
            giants.offer(-newHeight);

            magicLimit--;
            usedMagic++;
        }

        if (!giants.isEmpty() && -giants.peek() >= centiHeight) {
            System.out.println("NO");
            System.out.println(-giants.peek());
        } else {
            System.out.println("YES");
            System.out.println(usedMagic);
        }
    }
}