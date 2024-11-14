

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 1, map, N);
        System.out.println(result);
    }

    // dir 1 : 가로, 2 : 세로, 3 : 대각

    // 현재 x, 현재 y, 현재 방향, map, map 크기
    private static void dfs(int x, int y, int dir, int[][] map, int N) {
        if (x == N - 1 && y == N - 1) {
            result++;
            return;
        }

        // dir : 가로 -> 가로, 대각
        if (dir == 1) {
            // 가로 이동
            if (y + 1 < N && map[x][y + 1] != 1) {
                dfs(x, y + 1, 1, map, N);
            }

            //대각선 이동
            if (x + 1 < N && y + 1 < N && map[x][y + 1] != 1 && map[x + 1][y] != 1 && map[x + 1][y + 1] != 1) {
                dfs(x + 1, y + 1, 3, map, N);
            }
        }

        // dir : 세로 -> 세로, 대각
        if (dir == 2) {
            //세로 이동
            if (x + 1 < N && map[x + 1][y] != 1) {
                dfs(x + 1, y, 2, map, N);
            }

            //대각선 이동
            if (x + 1 < N && y + 1 < N && map[x][y + 1] != 1 && map[x + 1][y] != 1 && map[x + 1][y + 1] != 1) {
                dfs(x + 1, y + 1, 3, map, N);
            }
        }

        // dir : 대각 -> 가로, 세로, 대각
        if (dir == 3) {
            //가로 이동
            if (y + 1 < N && map[x][y + 1] != 1) {
                dfs(x, y + 1, 1, map, N);
            }

            //세로 이동
            if (x + 1 < N && map[x + 1][y] != 1) {
                dfs(x + 1, y, 2, map, N);
            }

            //대각선 이동
            if (x + 1 < N && y + 1 < N && map[x][y + 1] != 1 && map[x + 1][y] != 1 && map[x + 1][y + 1] != 1) {
                dfs(x + 1, y + 1, 3, map, N);
            }
        }


    }
}
