import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 학생 수를 받는다.
        int students = Integer.parseInt(br.readLine());

        // 2. 뽑은 번호를 받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> line = new ArrayList<>();

        // 3. 학생들을 차례대로 줄 세운다.
        for (int i = 1; i <= students; i++) {
            int pickNumber = Integer.parseInt(st.nextToken());
            line.add(line.size() - pickNumber, i);
        }

        // 4. 출력한다.
        for (int student: line) {
            System.out.print(student + " ");
        }
    }
}