import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            System.out.println(isValidParenthesisString(str) ? "YES" : "NO");
        }
    }

    public static boolean isValidParenthesisString(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch: str.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}