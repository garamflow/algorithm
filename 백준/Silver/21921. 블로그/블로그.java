import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 시작하고 지난 일수
        int X = Integer.parseInt(st.nextToken()); // 특정일

        int[] people = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[] myArray = new int[X];
        int sum = 0;
        int currentSum = 0;
        int maxPeople = 0;
        int count = 0;

        for (int i = 0; i < X; i++) {
            currentSum += people[i];
        }

        maxPeople = currentSum;
        count = 1;

        for(int i = X; i < N; i++) {
            currentSum += people[i] - people[i - X];

            if(currentSum > maxPeople) {
                maxPeople = currentSum;
                count = 1;
            } else if(currentSum == maxPeople) {
                count++;
            }
        }

        if(maxPeople == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxPeople);
            System.out.println(count);
        }
    }
}