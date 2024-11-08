

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

        // 행 확인
        for (int i = 0; i < N; i++) {
            if (isValidPath(map[i], L)) {
                count++;
            }
        }

        // 열 확인
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
        int n = path.length;
        boolean[] used = new boolean[n]; // 경사로 설치 여부

        for (int i = 0; i < n - 1; i++) {
            if (path[i] == path[i + 1]) {
                continue; // 높이가 같으면 진행
            }

            if (path[i] + 1 == path[i + 1]) { // 상승하는 경사로
                for (int j = 0; j < L; j++) {
                    // 경사로 설치 공간 부족한 경우, 경사로를 설치한 공간의 높이가 다른 경우, 경사로가 설치되어있는 경우
                    if (i - j < 0 || path[i - j] != path[i] || used[i - j]) {
                        return false;
                    }
                    used[i - j] = true;
                }
            } else if (path[i] - 1 == path[i + 1]) { // 하강하는 경사로
                for (int j = 0; j < L; j++) {
                    // 경사로가 map을 넘어가는 경우, 경사로를 설치한 공간의 높이가 다른 경우, 경사로가 설치되어있는 경우
                    if (i + 1 + j >= n || path[i + 1 + j] != path[i + 1] || used[i + 1 + j]) {
                        return false;
                    }
                    used[i + 1 + j] = true;
                }
            } else {
                return false; // 높이 차이가 1보다 크면 불가능
            }
        }

        return true;
    }
}
