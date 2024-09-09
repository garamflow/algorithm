import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= M) {
                sum -= numbers[start];
                start++;
            } else if (end < length) {
                sum += numbers[end];
                end++;
            } else {
                break;
            }

            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}