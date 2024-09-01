

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int result = -1;

        for (int i = N / 5; i >= 0; i--) {
            int remaining = N - (i * 5);
            if (remaining % 3 == 0) {
                result = i + (remaining / 3);
                break;
            }
        }
        System.out.println(result);
    }
}
