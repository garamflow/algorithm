import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int n, m;

    // 우, 하
    static int[][] DIRECTION = new int[][] {{0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로 크기
        m = Integer.parseInt(st.nextToken()); // 가로 크기

        graph = new char[n][m];
        visited = new boolean[n][m];

        // 바닥 장식을 graph[][]에 저장
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        // 나무 판자의 개수
        int count = 0;

        // 전체 배열 순회하면서 방문하지 않은 판자 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 해당 나무판자에 방문안했다면 dfs 실행
                if(!visited[i][j]){
                    dfs(i, j); // 판자를 방문 처리
                    count++; //  판자 개수 증가
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y) {
        // 현재 판자 방문 처리
        visited[x][y] = true;
        // 현재 방문한 판자(-, |)
        char currentChar = graph[x][y];

        for (int[] direction : DIRECTION) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if(newX < n && newY < m && !visited[newX][newY] && graph[newX][newY] == currentChar){
                if(currentChar == '-' && direction[0] == 0){
                    dfs(newX, newY);
                } else if (currentChar == '|' && direction[1] == 0) {
                    dfs(newX, newY);
                }
            }
        }
    }
}
