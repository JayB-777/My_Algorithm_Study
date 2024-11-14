

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
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

        int max = 100000;
        boolean[] visited = new boolean[max + 1];
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[] {N, 0}); // 현재위치, 시간

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int position = current[0];
            int time = current[1];

            if (position == K) {
                return time;
            }

            // teleport
            int teleportPosition = position * 2;
            if (teleportPosition <= max && !visited[teleportPosition]) {
                visited[teleportPosition] = true;
                deque.addFirst(new int[] {teleportPosition, time});
            }

            // walk
            int[] walkPosition = {position - 1, position + 1};
            for (int walk : walkPosition) {
                if (walk >= 0 && walk <= max && !visited[walk]) {
                    visited[walk] = true;
                    deque.add(new int[] {walk, time + 1});
                }
            }
        }
        return -1;
    }
}
