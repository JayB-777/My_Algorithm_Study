

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] timeArr = new int[N];
        int[] payArr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            timeArr[i] = Integer.parseInt(st.nextToken());
            payArr[i] = Integer.parseInt(st.nextToken());
        }

        // day, profit, N, timeArr, payArr
        dfs(0, 0, N, timeArr, payArr);
        System.out.println(result);

    }

    private static void dfs(int day, int profit, int N, int[] timeArr, int[] payArr) {
        if (day >= N) {
            result = Math.max(result, profit);
            return;
        }

        // 상담을 받는 경우
        if (day + timeArr[day] <= N) {
            dfs(day + timeArr[day], profit + payArr[day], N, timeArr, payArr);
        }
        // 상담을 받지 않은 경우
        dfs(day + 1, profit, N, timeArr, payArr);
    }
}
