import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testcases = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testcases; i++) {
            st = new StringTokenizer(br.readLine());
            int leftNumber = Integer.parseInt(st.nextToken());
            int rightNumber = Integer.parseInt(st.nextToken());

            while(leftNumber != rightNumber) {
                if (rightNumber > leftNumber) {
                    rightNumber = rightNumber / 2;
                } else {
                    leftNumber = leftNumber / 2;
                }
            }

            sb.append(leftNumber * 10).append("\n");
        }

        System.out.println(sb.toString());
    }
}
