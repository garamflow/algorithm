import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static int K;
    static int[] arr;
    static int[] temp;
    static int result = -1;

    public static void mergeSort(int left, int right) {
        if (left < right && count <= K) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int t = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
            count++;
            if (count == K) {
                result = temp[t - 1];
                return;
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
            count++;
            if (count == K) {
                result = temp[t - 1];
                return;
            }
        }

        while (j <= right) {
            temp[t++] = arr[j++];
            count++;
            if (count == K) {
                result = temp[t - 1];
                return;
            }
        }

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        System.out.println(result);
    }
}
