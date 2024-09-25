import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int count = 0;

        while(input.length() > 1) {
            int sum = 0;
            
            for (char c: input.toCharArray()) {
                sum += c - '0';
            }
            input = String.valueOf(sum);
            count++;
        }

        System.out.println(count);
        int number = Integer.parseInt(input);
        if(number % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}