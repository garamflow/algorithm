import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = N - 1; i > 0; i--) {
            int max = i;

            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[max]) {
                    max = j;
                }
            }

            if (i != max) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
                count++;

                if(count == K) {
                    System.out.println(Math.min(arr[i],arr[max]) + " " + Math.max(arr[i],arr[max]));
                    break;
                }
            }
        }

        if (count < K) {
            System.out.println(-1);
        }
    }
}