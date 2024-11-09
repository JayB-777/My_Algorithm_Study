

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int B = 0;
    static int C = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] testRoom = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            testRoom[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long result = 0;

        for (int i = 0; i < N; i++) {
            result += solution(testRoom[i]);
        }

        System.out.println(result);
    }


    private static long solution(int testerNum) {
        long result = 1;
        long remaining = testerNum - B;

        if (remaining > 0) {
            result += (remaining + C - 1) / C;
        }
        return result;
    }
}
