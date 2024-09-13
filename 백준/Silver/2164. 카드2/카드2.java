

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static int N;
    public static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>(N);
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        solve(deque);
        System.out.println(deque.poll());
    }

    private static void solve(Deque deque) {
        if (deque.size() == 1) {
            return;
        }
        deque.poll();
        deque.addLast(deque.poll());
        solve(deque);
    }
}
