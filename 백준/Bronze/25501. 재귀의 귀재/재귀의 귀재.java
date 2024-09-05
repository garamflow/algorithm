import java.util.Scanner;

public class Main {
    static int number = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();

        
        for (int i = 0; i < x; i++) {
			String str = sc.nextLine();
            number = 0;
            System.out.println(isPalindrome(str) + " " + number);
        }
        sc.close();
    }

    public static int recursion(String str, int l, int r) {
        number++;
        if (l >= r) {
            return 1;
        } else if (str.charAt(l) != str.charAt(r)) {
            return 0;
        } else {
            return recursion(str, l + 1, r - 1);
        }
    }

    public static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }
}