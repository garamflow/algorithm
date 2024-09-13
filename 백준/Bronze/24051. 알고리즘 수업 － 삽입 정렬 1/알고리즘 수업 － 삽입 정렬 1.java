import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int result = 0;

        outer: for (int i = 1; i < N; i++) {
            int location = i - 1;
            int current = arr[i];

            while (location >= 0 && current < arr[location]) {
                arr[location + 1] = arr[location];
                count++;
                if (count == K) {
                    result = arr[location + 1];
                    break outer;
                }
                location--;
            }

            if (location + 1 != i) {
                arr[location + 1] = current;
                count++;
                if(count == K) {
                    result = arr[location + 1];
                    break;
                }
            }
        }

        if (count < K) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}