

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        // 행
        for (int i = 0; i < N; i++) {
            if (isValidPath(map[i], L)) {
                count++;
            }
        }

        //열
        for (int i = 0; i < N; i++) {
            int[] col = new int[N];
            for (int j = 0; j < N; j++) {
                col[j] = map[j][i];
            }
            if (isValidPath(col, L)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isValidPath(int[] path, int L) {
        int N = path.length;
        boolean[] used = new boolean[N];

        for (int i = 0; i < N - 1; i++) {

            //높이가 같은 경우
            if (path[i] == path[i + 1]) {
                continue;
            }

            //상승
            if (path[i] + 1 == path[i + 1]) {
                for (int j = 0; j < L; j++) {
                    // 경사로 놓을 칸이 부족한 경우, 경사로 설치 공간의 높이가 일정하지 않은 경우, 이미 경사로가 설치된 경우
                    if (i - j < 0 || path[i - j] != path[i] || used[i - j]) {
                        return false;
                    }
                    used[i - j] = true;
                }
            }

            //하강
            else if (path[i] - 1 == path[i + 1]) {
                for (int j = 0; j < L; j++) {
                    // 경사로를 놓았을 시 map을 넘어가는 경우, 경사로 설치공간의 높이가 일정하지 않는 경우, 이미 경사로가 설치된 경우
                    if (i + 1 + j >= N || path[i + 1 + j] != path[i + 1] || used[i + 1 + j]) {
                        return false;
                    }
                    used[i + 1 + j] = true;
                }

            }

            // 높이 차이가 1이 아닌 경우
            else {
                return false;
            }

        }

        return true;
    }
}
