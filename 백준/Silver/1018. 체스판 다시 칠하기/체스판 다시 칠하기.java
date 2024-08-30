

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static char[][] arr;
    public static int rows;
    public static int cols;
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        arr = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= rows - 8; i++) {
            for (int j = 0; j <= cols - 8; j++) {
                solve(i, j);
            }
        }

        System.out.println(result);
    }

    private static void solve(int x, int y) {
        char[] patterns = {'B', 'W'};
        for (int p = 0; p < 2; p++) {
            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (arr[x + i][y + j] != patterns[(i + j + p) % 2]) {
                        count++;
                    }
                }
            }
            result = Math.min(result, count);
        }
    }
}