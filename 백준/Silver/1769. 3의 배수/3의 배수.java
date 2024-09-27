import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 숫자 문자열로 받음 (너무 길어서)
        int count = 0;

        while(input.length() > 1) { // 한 자리 수 될 때까지 반복하기
            int sum = 0;

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i) - '0');
            }

            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            input = Integer.toString(sum);
            count++;
        }

        System.out.println(count);
        System.out.println(Integer.parseInt(input) % 3 == 0 ? "YES" : "NO");
        
        br.close();
    }
}