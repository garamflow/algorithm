import java.util.Scanner;

public class Main {

	static int n = 0;
	static int m = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		fib(x);
		fibonacci(x);

		System.out.println(n + " " + m);
		sc.close();
	}

	public static int fib(int x) {
		if (x == 1 || x == 2) {
			n++;
			return 1;
		} else {
			return fib(x - 1) + fib(x - 2);
		}
	}

	public static int fibonacci(int x) {
		int[] f = new int[x + 1];
		f[1] = f[2] = 1;

		for(int i = 3; i <= x; i++) {
			f[i] = f[i - 1] + f[i - 2];
			m++;
		}

		return f[x];
	}
}