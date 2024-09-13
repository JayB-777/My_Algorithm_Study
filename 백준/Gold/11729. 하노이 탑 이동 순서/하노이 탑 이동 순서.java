

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        hanoi(n - 1, from, aux, to);
        sb.append(from).append(" ").append(to).append("\n");
        count++;
        hanoi(n - 1, aux, to, from);
    }

}
