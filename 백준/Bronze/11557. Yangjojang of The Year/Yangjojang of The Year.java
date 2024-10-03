import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class School {
        String name;
        Integer alcohol;

        School(String name, Integer alcohol) {
            this.name = name;
            this.alcohol = alcohol;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int schoolCount = Integer.parseInt(st.nextToken());
            School[] school = new School[schoolCount];

            for (int j = 0; j < schoolCount; j++) {
                st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();
                int alcohol = Integer.parseInt(st.nextToken());

                school[j] = new School(schoolName, alcohol);
            }

            Arrays.stream(school)
                    .min((a, b) -> b.alcohol.compareTo(a.alcohol))
                    .ifPresent(sc -> sb.append(sc.name).append("\n"));
        }

        System.out.println(sb);
    }
}
