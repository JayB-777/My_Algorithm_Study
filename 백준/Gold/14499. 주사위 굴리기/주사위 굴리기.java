

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] dx = {0, 0, -1, 1}; // 동, 서, 북, 남
    static int[] dy = {1, -1, 0, 0};
    static int[] dice = new int[6]; //상 북 동 서 남 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int command = Integer.parseInt(st.nextToken());
            int nx = x + dx[command - 1];
            int ny = y + dy[command - 1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            rollDice(command);
            x = nx;
            y = ny;

            if (map[x][y] == 0) {
                map[x][y] = dice[5];
            } else {
                dice[5] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[0]);
        }
    }

    private static void rollDice(int command) {
        int[] temp = dice.clone();
        switch (command) {
            case 1:
                dice[0] = temp[3];
                dice[2] = temp[0];
                dice[3] = temp[5];
                dice[5] = temp[2];
                break;
            case 2:
                dice[0] = temp[2];
                dice[2] = temp[5];
                dice[3] = temp[0];
                dice[5] = temp[3];
                break;
            case 3:
                dice[0] = temp[4];
                dice[1] = temp[0];
                dice[4] = temp[5];
                dice[5] = temp[1];
                break;
            case 4:
                dice[0] = temp[1];
                dice[1] = temp[5];
                dice[4] = temp[0];
                dice[5] = temp[4];
                break;
        }
    }
}
