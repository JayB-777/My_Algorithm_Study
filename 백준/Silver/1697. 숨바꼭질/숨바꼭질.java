

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        if (N == K) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int max = 100000;
        boolean[] visited = new boolean[max + 1];
        visited[N] = true;

        //현재 위치, 시간
        queue.add(new int[] {N, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            int[] nextPosition = {position - 1, position + 1, position * 2};
            for (int next : nextPosition) {
                if (next == K) {
                    return time + 1;
                }
                if (next >= 0 && next <= max && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, time + 1});
                }
            }
        }
        return -1;

    }
}
