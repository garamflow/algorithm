import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
		for (int i = 1; i <= num; i++) {
			System.out.print("*".repeat(i));
			System.out.print(" ".repeat(num * 2 - i * 2));
			System.out.println("*".repeat(i));
		}
		
		for (int j = num - 1; j > 0; j--) {
			System.out.print("*".repeat(j));
			System.out.print(" ".repeat(num * 2 - j * 2));
			System.out.println("*".repeat(j));
		}
    }
}