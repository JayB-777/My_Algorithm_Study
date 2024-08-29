

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 666;
        int result = solve(count, num);
        System.out.println(result);
    }

    private static int solve(int count, int num) {
        while (count < n) {
            if (String.valueOf(num).contains("666")) {
                count++;
            }
            if (count < n) {
                num++;
            }
        }
        return num;
    }
}
