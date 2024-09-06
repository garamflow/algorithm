import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArray = br.readLine().split(" ");

		String reverseStrA = new StringBuilder(strArray[0]).reverse().toString();
		String reverseStrB = new StringBuilder(strArray[1]).reverse().toString();

		int reverseIntA = Integer.parseInt(reverseStrA);
		int reverseIntB = Integer.parseInt(reverseStrB);

		int result = reverseIntA >= reverseIntB ? reverseIntA : reverseIntB;

		System.out.println(result);
	}
}