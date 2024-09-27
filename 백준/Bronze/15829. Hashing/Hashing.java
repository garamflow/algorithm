import java.util.*;
import java.io.*;

public class Main {
    public static int getAlphabetValue(char ch) {
        return ch - 'a' + 1;
    }

    public static void main(String[] args) throws IOException {
        int r = 31;
        int M = 1234567891;

        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(); // 길이
        String input = sc.next(); // 알파벳
        long sum = 0;
        long powValue = 1;

        for (int i = 0; i < L; i++) {
            int alpha = input.charAt(i) - 'a' + 1;
            sum = (sum + alpha * powValue) % M;
            powValue = (powValue * r) % M;
        }

        System.out.println(sum);
        sc.close();
    }
}