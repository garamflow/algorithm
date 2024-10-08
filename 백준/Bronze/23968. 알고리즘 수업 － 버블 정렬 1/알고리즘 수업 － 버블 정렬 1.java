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
        int left = 0;
        int right = 0;

        for (int i = 0; i < N - 1; i++) {
            for(int j = 0; j < N - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;

                    if(count == K) {
                        left = arr[j];
                        right = arr[j + 1];
                    }
                }
            }
        }

        if(count < K) {
            System.out.println(-1);
        } else {
            System.out.println(left + " " + right);
        }
    }
}