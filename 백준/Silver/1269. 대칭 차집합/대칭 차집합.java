import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < K; i++) {
            set2.add(Integer.parseInt(st.nextToken()));
        }

        // set1 - set2
        for (int number: set1) {
            if(!set2.contains(number)) {
                count++;
            }
        }

        // set2 - set1
        for (int number: set2) {
            if(!set1.contains(number)) {
                count++;
            }
        }

        System.out.println(count);
    }
}