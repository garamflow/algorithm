import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] frequency = new int[8001];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int num = Integer.parseInt(s);
            arr[i] = num;
            sum += arr[i];
            frequency[num + 4000]++;
        }

        double m = (double) sum / N;
        sb.append(Math.round(m)).append("\n");

        Arrays.sort(arr);
        sb.append(arr[N/2]).append("\n");

        int maxFreq = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if(frequency[i] > maxFreq){
                maxFreq = frequency[i];
                list.clear();
                list.add(i - 4000);
            } else if (frequency[i] == maxFreq){
                list.add(i - 4000);
            }
        }

        if (list.size() > 1) {
            Collections.sort(list);
            sb.append(list.get(1)).append("\n");
        } else {
            sb.append(list.get(0)).append("\n");
        }

        int range = arr[N - 1] - arr[0];
        sb.append(range).append("\n");

        System.out.println(sb);
    }
}
