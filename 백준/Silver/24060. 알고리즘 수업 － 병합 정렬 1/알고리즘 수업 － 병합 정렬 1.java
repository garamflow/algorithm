import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static int K;
    static int[] sorted; // 임시 저장 배열
    static int result = -1;

    public static void mergeSort(int[] arr) {
        sorted = new int[arr.length]; // 임시 배열 초기화
        mergeSort(arr, 0, arr.length - 1); // 병합 정렬 호출
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
            count++;
            if (count == K) {
                result = sorted[k - 1];
                return;
            }
        }

        while (i <= mid) {
            sorted[k++] = arr[i++];
            count++;
            if (count == K) {
                result = sorted[k - 1];
                return;
            }
        }

        while (j <= right) {
            sorted[k++] = arr[j++];
            count++;
            if (count == K) {
                result = sorted[k - 1];
                return;
            }
        }

        for (int l = left; l <= right; l++) {
            arr[l] = sorted[l];
        }
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

        mergeSort(arr);

        System.out.println(result);
    }
}