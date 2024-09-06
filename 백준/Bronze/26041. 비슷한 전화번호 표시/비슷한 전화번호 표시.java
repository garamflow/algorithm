import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numberSet = br.readLine().split(" ");
        String beginning = br.readLine();
        br.close();
        int count = 0;
        for (String s : numberSet) {
            if (!Objects.equals(s, beginning) && s.startsWith(beginning)) {
                count++;
            }
        }
        System.out.println(count);
    }
}