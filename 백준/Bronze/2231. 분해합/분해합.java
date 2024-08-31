
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        solve(N);
        System.out.println(result);
    }

    private static void solve(int N) {
        for (int i = 1; i < N; i++) {
            int sum = i;
            int num = i;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == N) {
                result = i;
                break;
            }
        }
    }
}
