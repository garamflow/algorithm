import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			String[] input = br.readLine().split(" ");
			int repeatCount = Integer.parseInt(input[0]);
			String str = input[1];

			StringBuilder sb = new StringBuilder();

			for(char ch: str.toCharArray()) {
				for(int j = 0; j < repeatCount; j++) {
					sb.append(ch);
				}
			}

			System.out.println(sb);
		}
	}
}