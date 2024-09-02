

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int T;
    public static int N;
    public static int M;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = solve(N, M);
            System.out.println(result);
        }

    }

    private static int solve(int N, int M) {
        if (N > M - N) {
            N = M - N;
        }

        int result = 1;
        for (int i = 0; i < N; i++) {
            result *= (M - i);
            result /= (i + 1);
        }
        return result;
    }
}
