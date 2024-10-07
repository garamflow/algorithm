import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static String[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new String[10][10];
        visited = new boolean[10][10];

        int[] start = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                graph[i][j] = line.charAt(j) + "";
                if (graph[i][j].equals("B")) {
                    start[0] = i;
                    start[1] = j;
                }
                if (graph[i][j].equals("L")) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int result = bfs(start, end);
        System.out.println(result);
    }

    static int bfs(int[] start, int[] end) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 목표 지점인 호수에 도달한 경우
                if (x == end[0] && y == end[1]) {
                    return count - 1; // Barn과 Lake 바로 옆이 아니므로 소들 간 거리에서 1 뺌
                }

                // 인접한 네 방향으로 탐색
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    // 배열 범위 내에 있는지, 방문 여부, 장애물 여부 확인
                    if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
                    if (visited[nx][ny] || graph[nx][ny].equals("R")) continue;

                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
            count++;
        }

        return -1; // 목표 지점에 도달하지 못하는 경우
    }
}
