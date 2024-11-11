

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 0 : 북 , 1 : 동, 2 : 남, 3 : 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N = 0;
    static int M = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, x, y, dir);
        System.out.println(count);

    }

    private static void dfs(int[][] map, int x, int y, int dir) {

        // 청소가 가능한 경우
        if (map[x][y] == 0) {
            map[x][y] = 2;
            count++;
        }


        // 4방향 검사
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                dfs(map, nx, ny, dir);
                return;
            }
        }

        // 후진
        int backDir = (dir + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];

        if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
            dfs(map, bx, by, dir);
        }
    }
}
