import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 아는 노래 개수
        int M = Integer.parseInt(st.nextToken()); // 맞히기 시도할 노래 개수

        HashMap<String, List<String>> map = new HashMap<>();

        // HashMap에 노래 정보 입력해서 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            String title = st.nextToken();
            StringBuilder three = new StringBuilder();

            for (int j = 0; j < 7; j++) {
                String note = st.nextToken();
                if (j < 3) three.append(note);
            }

            // 첫 세음을 키로 하고, 그 키에 노래 제목을 저장할 리스트가 필요
            // 없다면 새로운 리스트 생성
            // three.toStrin(): 문자열로 변환
            // new ArrayList<>(): 빈 리스트 생성
            map.putIfAbsent(three.toString(), new ArrayList<>());
            
            // 첫 세 음에 맞는 리스트를 노래 가져와서 노래 제목을 추가한다.
            map.get(three.toString()).add(title);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String m1 = st.nextToken(); // 첫 번째 음
            String m2 = st.nextToken(); // 두 번째 음
            String m3 = st.nextToken(); // 세 번째 음
            String plus = m1 + m2 + m3; // 첫 세 음

            if (map.containsKey(plus)) {
                List<String> matching = map.get(plus);
                if(matching.size() == 1) {
                    sb.append(matching.get(0)).append("\n");
                } else {
                    sb.append("?").append("\n");
                }
            } else {
                sb.append("!").append("\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}