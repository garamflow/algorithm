import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static int K;
    static int left = -1;
    static int right = -1;

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1; // 초기화
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        if(i + 1 != end) {
            swap(arr, i + 1, end);
        }

        return i + 1;
    }

    public static void swap(int[] arr, int index1, int index2) {
        count++;
        if(count == K) {
            left = Math.min(arr[index1], arr[index2]);
            right = Math.max(arr[index1], arr[index2]);
        }
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N - 1);

        if(left == -1) {
            System.out.println(-1);
        } else {
            System.out.println(left + " " + right);
        }
    }
}