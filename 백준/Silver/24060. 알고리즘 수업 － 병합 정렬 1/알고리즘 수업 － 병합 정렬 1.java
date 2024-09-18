import java.io.*;
import java.util.*;

public class Main {
    static int count = 0; // 저장 횟수 변수
    static int K; // K번째 저장 수
    static int[] arr; // 입력되는 배열
    static int[] temp; // 임시 배열
    static int result = -1; // 결과 저장 변수

    public static void mergeSort(int start, int end) {
        /*
          주어지는 배열을 분할하고 재귀적으로 정렬
          조건: 시작 인덱스가 끝 인덱스보다 작고, count가 K 이하일 때
          배열을 절반으로 나누어 왼쪽과 오른쪽 부분 배열을 정렬한 후 병합
         */
        if (start < end && count <= K) {
            int mid = (start + end) / 2; // 중간 인덱스
            mergeSort(start, mid); // 왼쪽 배열
            mergeSort(mid + 1, end); // 오른쪽 배열
            merge(start, mid, end); // 병합 함수
        }
    }

    public static void merge(int start, int mid, int end) {
        /*
         * 두 개의 정렬된 부분 배열을 병합
         * i: 왼쪽 부분 배열 현재 인덱스 (start ~ mid)
         * j: 오른쪽 부분 배열 현재 인덱스 (mid+1 ~ end)
         * tempIndex: 임시 배열(temp)에 값 저장 인덱스
         */
        int i = start;
        int j = mid + 1;
        int tempIndex = start;

        /*
         * 왼쪽, 오른쪽 배열의 요소를 비교하여 작은 순서대로 temp에 저장
         * 저장할 때마다 count를 증가시키고, count가 K와 같아지면 결과 저장 후 리턴
         */
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                // 왼쪽 배열 값 저장하기
                temp[tempIndex++] = arr[i++];
            } else {
                // 오른쪽 배열 값 저장하기
                temp[tempIndex++] = arr[j++];
            }
            count++;
            if (count == K) {
                // K 번째 저장 값을 결과에 저장
                result = temp[tempIndex - 1];
                return;
            }
        }

        /*
        * 왼쪽 배열 남은 요소를 temp에 저장
        * 저장할 때마다 count 증가, K와 같아지면 저장하고 리턴
        */
        while (i <= mid) {
            temp[tempIndex++] = arr[i++];
            count++;
            if (count == K) {
                result = temp[tempIndex - 1];
                return;
            }
        }

        /*
         * 오른쪽 배열 남은 요소를 temp에 저장
         * 저장할 때마다 count 증가, K와 같아지면 저장하고 리턴
         */
        while (j <= end) {
            temp[tempIndex++] = arr[j++];
            count++;
            if (count == K) {
                result = temp[tempIndex - 1];
                return;
            }
        }

        /*
        * temp 배열에 저장된 내용을 원본 배열 arr로 복사한다.
        * System.arraycopy 사용 시, 성능적으로 유리
        */
        if (end + 1 - start >= 0)
            System.arraycopy(temp, start, arr, start, end + 1 - start);
        /*
        * temp: 원본 배열
        * start: 원본 배열 복사 시작 인덱스
        * arr: 대상 배열
        * start: 대상 배열에서 복사 시작 인덱스
        * end + 1 - start: 복사할 요소 수
        */
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