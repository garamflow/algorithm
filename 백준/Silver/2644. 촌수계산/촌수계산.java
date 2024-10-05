import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int peopleCount = Integer.parseInt(st.nextToken()); // 전체 사람의 수
        graph = new ArrayList[peopleCount + 1];
        visited = new int[peopleCount + 1];

        for(int i = 1; i <= peopleCount; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int personNumber1 = Integer.parseInt(st.nextToken()); // 촌수 계산 필요 사람1
        int personNumber2 = Integer.parseInt(st.nextToken()); // 촌수 계산 필요 사람2

        int relation = Integer.parseInt(br.readLine()); // 부모 자식들 간 관계의 수

        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph[parent].add(child);
            graph[child].add(parent);
        }

        int reulst = bfs(personNumber1, personNumber2);
        System.out.println(reulst);
    }

    static int bfs(int start, int target) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) {
                return visited[current] - 1;
            }

            for (int nextStep: graph[current]) {
                if (visited[nextStep] == 0) {
                    queue.add(nextStep);
                    visited[nextStep] = visited[current] + 1;
                }
            }
        }

        return -1;
    }
}
