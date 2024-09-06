import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int row = 0;
        int col = 0;

        for (int i = 1; i < 10; i ++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            for (int j = 1; j < 10; j++) {
                int token = Integer.parseInt(st.nextToken());
                if (max < token) {
                    max = token;
                    row = i;
                    col = j;
                }
            }
        }

        if(max == 0) {
            System.out.println(0);
            System.out.println(1 + " " + 1);
        }

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}