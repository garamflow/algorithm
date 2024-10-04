import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Applicant {
        int document;
        int interview;

        public Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testcases = Integer.parseInt(st.nextToken());

        List<Applicant> applicantList = new ArrayList<>();

        for (int i = 0; i < testcases; i++) {
            st = new StringTokenizer(br.readLine());
            int applicant = Integer.parseInt(st.nextToken());
            Applicant[] applicantArray = new Applicant[applicant];

            for (int j = 0; j < applicant; j++) {
                st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                applicantArray[j] = new Applicant(document, interview);
            }

            Arrays.sort(applicantArray, Comparator.comparingInt(a -> a.document));
            int interviewBest = applicantArray[0].interview;
            int count = 1;

            for (Applicant value : applicantArray) {
                if (value.interview < interviewBest) {
                    count++;
                    interviewBest = value.interview;
                }
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);
    }
}
