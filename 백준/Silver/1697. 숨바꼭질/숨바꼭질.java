import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] visited;
    static int MAX_LENGTH = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[MAX_LENGTH + 1];

        int result = bfs(N);
        System.out.println(result);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == K) {
                return visited[now] - 1;
            }

            int[] Direction = {now - 1, now + 1, now * 2};

            for (int next : Direction) {
                if(next >= 0 && next <= MAX_LENGTH && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }

        return -1;
    }
}
