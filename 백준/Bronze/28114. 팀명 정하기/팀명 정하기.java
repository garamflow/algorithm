import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Member {
        Integer solvedCount;
        String year;
        String name;

        Member(Integer solvedCount, String year, String name) {
            this.solvedCount = solvedCount;
            this.year = year;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Member[] members = new Member[3];

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int solvedCount = Integer.parseInt(st.nextToken());
            String year = st.nextToken();
            String name = st.nextToken();
            members[i] = new Member(solvedCount, year, name);
        }

        String[] yearArray = new String[3];
        for (int i = 0; i < 3; i++) {
            yearArray[i] = members[i].year.substring(2);
        }
        Arrays.sort(yearArray);
        for(int i = 0; i < 3; i++) {
            sb.append(yearArray[i]);
        }

        sb.append("\n");

        Arrays.stream(members)
                .sorted((a, b) -> b.solvedCount.compareTo(a.solvedCount))
                .forEach(member -> sb.append(member.name.charAt(0)));


        System.out.println(sb);
    }
}
