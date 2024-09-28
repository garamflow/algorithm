import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가 수
            int M = Integer.parseInt(st.nextToken()); // 비행기 종류

            for (int j = 0; j < M; j++) {
                br.readLine();
            }

            // 최소한 모든 국가 여행을 위해 필요한 비행기 수 N - 1
            sb.append(N - 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
