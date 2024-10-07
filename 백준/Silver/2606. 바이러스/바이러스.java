import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 그래프 초기화하기
        int numComputers = Integer.parseInt(st.nextToken());

        graph = new ArrayList[numComputers + 1];
        for (int i = 1; i <= numComputers; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결 정보 입력하기
        st = new StringTokenizer(br.readLine());
        int numPairs = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < numPairs; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[numComputers + 1];
        int virus = bfs(1) - 1;
        System.out.println(virus);
    }

    static int bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int next: graph[current]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return count;
    }
}
