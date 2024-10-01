import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int maxStudentsCount = 0;
        int lastStudentNumber = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type == 1) {
                int student = Integer.parseInt(st.nextToken());
                queue.offer(student);

                if(queue.size() > maxStudentsCount) {
                    maxStudentsCount = queue.size();
                    lastStudentNumber = student;
                } else if(queue.size() == maxStudentsCount) {
                    lastStudentNumber = Math.min(lastStudentNumber, student);
                }
            } else if (type == 2) {
                queue.poll();
            }
        }

        System.out.println(maxStudentsCount + " " + lastStudentNumber);
    }
}
