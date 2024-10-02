import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static char[][] graph;
    static int height, width;
    static int totalSheep, totalWolf;

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        graph = new char[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(!visited[i][j] && graph[i][j] != '#'){
                    bfs(i, j);
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        int wolfCount = 0, sheepCount = 0;

        if(graph[x][y] == 'v') wolfCount++;
        if(graph[x][y] == 'k') sheepCount++;

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});

        while(!queue.isEmpty()){
            Integer[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];


                if (nextX >= 0 && nextX < height && nextY >= 0 && nextY < width && !visited[nextX][nextY] && graph[nextX][nextY] != '#') {
                    visited[nextX][nextY] = true;
                    queue.add(new Integer[]{nextX, nextY});

                    if(graph[nextX][nextY] == 'k') sheepCount++;
                    if(graph[nextX][nextY] == 'v') wolfCount++;
                }
            }
        }

        if (sheepCount > wolfCount) {
            totalSheep += sheepCount;
        } else {
            totalWolf += wolfCount;
        }
    }
}
