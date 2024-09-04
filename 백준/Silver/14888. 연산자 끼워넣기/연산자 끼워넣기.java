

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int[] arr;
    public static int[] operator = new int[4];
    public static int maxResult = Integer.MIN_VALUE;
    public static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[T];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr[0], 1);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    private static void solve(int currentResult, int idx) {
        if (idx == T) {
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);
            return;
        }

        if (operator[0] > 0) {
            operator[0]--;
            solve(currentResult + arr[idx], idx + 1);
            operator[0]++;
        }
        if (operator[1] > 0) {
            operator[1]--;
            solve(currentResult - arr[idx], idx + 1);
            operator[1]++;
        }
        if (operator[2] > 0) {
            operator[2]--;
            solve(currentResult * arr[idx], idx + 1);
            operator[2]++;
        }
        if (operator[3] > 0) {
            operator[3]--;
            solve(currentResult / arr[idx], idx + 1);
            operator[3]++;
        }
    }
}
