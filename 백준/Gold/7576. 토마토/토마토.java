

import java.util.*;
import java.io.*;

class Main {

    static int col, row;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken()); // 가로
        row = Integer.parseInt(st.nextToken()); // 세로

        map = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        // 입력 및 익은 토마토 위치 큐에 추가
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j}); // 익은 토마토를 BFS 시작점으로
                }
            }
        }

        // BFS 수행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < row && ny < col && map[nx][ny] == 0) {
                	map[nx][ny] = map[x][y] + 1; // 날짜 갱신
                	queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 결과 계산
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1); // 안 익은 토마토가 남아있음
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        System.out.println(result - 1);
    }
}