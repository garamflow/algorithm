import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++ ) {
            StringBuilder sb = new StringBuilder(br.readLine());
            set.add(sb.toString());
            if (set.contains(sb.reverse().toString())) {
                int middleIndex = sb.length() / 2;
                System.out.println(sb.length() + " " + sb.charAt(middleIndex));
                break;
            }
        }

        br.close();
    }
}