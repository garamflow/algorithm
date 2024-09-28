import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i = 0; i < testCase; i++) {
            // 각 테스트 케이스의 의상의 수
            int n = Integer.parseInt(br.readLine());
            // 의상 종류, 개수를 저장한다.
            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상 이름 사용하지 않음 / 같은 이름을 가진 의상은 없다
                String clothesCategory = st.nextToken(); // 의상 종류

                // 의상 종류를 키로 가지는 hashMap
                // 의상 종류가 존재하지 않으면 0
                // 존재하면 값에 +1을 해준다.
                hashMap.put(clothesCategory, hashMap.getOrDefault(clothesCategory, 0) + 1);
            }

            // 경우의 수의 합 초기값 1 (곱셈 때문에)
            int sum = 1;
            // 의상 종류에 해당하는 의상 개수 : value
            for (int value: hashMap.values()) {
                // 예) headgear 2개 선택 + 입지 않은 경우 1개
                sum *= (value + 1);
            }

            // 아무것도 입지 않은 경우를 빼줘야한다.
            System.out.println(sum - 1);
        }
    }
}
