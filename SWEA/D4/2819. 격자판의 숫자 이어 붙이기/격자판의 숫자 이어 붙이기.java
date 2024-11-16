import java.util.*;
import java.io.*;

class Solution {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] map = new int[4][4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = calc(map);
            System.out.println("#" + test_case + " " + result);
        }
    }

    private static int calc(int[][] map) {
        HashSet<String> hashset = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                hashset.addAll(bfs(map, i, j));
            }
        }

        return hashset.size();
    }

    private static HashSet<String> bfs(int[][] map, int startX, int startY) {
        Queue<State> queue = new LinkedList<>();
        HashSet<String> results = new HashSet<>();
        queue.add(new State("", startX, startY));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            // 길이가 7이 되면 결과에 추가
            if (current.path.length() == 7) {
                results.add(current.path);
                continue;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                    queue.add(new State(current.path + map[nx][ny], nx, ny));
                }
            }
        }

        return results;
    }

    private static class State {
        String path;
        int x, y;

        State(String path, int x, int y) {
            this.path = path;
            this.x = x;
            this.y = y;
        }
    }
}