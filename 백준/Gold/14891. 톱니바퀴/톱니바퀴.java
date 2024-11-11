

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        gears = new ArrayList[4];

        for (int i = 0; i < 4; i++) {
            gears[i] = new ArrayList<>();
            String line = br.readLine();
            for (char c : line.toCharArray()) {
                gears[i].add(c - '0');
            }
        }

        int rollCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < rollCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int rollDir = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[4];
            rollGearWith(gearNum, rollDir, visited);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].get(0) == 1) {
                score += Math.pow(2, i);
            }
        }
        System.out.println(score);
    }

    private static void rollGearWith(int gearNum, int rollDir, boolean[] visited) {
        visited[gearNum] = true;

        // 왼쪽 기어 확인
        if (gearNum > 0 && !visited[gearNum - 1] && !gears[gearNum].get(6).equals(gears[gearNum - 1].get(2))) {
            rollGearWith(gearNum - 1, -rollDir, visited);
        }

        // 오른쪽 기어 확인
        if (gearNum < 3 && !visited[gearNum + 1] && !gears[gearNum].get(2).equals(gears[gearNum + 1].get(6))) {
            rollGearWith(gearNum + 1, -rollDir, visited);
        }

        rollGear(gearNum, rollDir);
    }

    private static void rollGear(int gearNum, int rollDir) {

        // 반시계방향 회전
        if (rollDir == -1) {
            int temp = gears[gearNum].get(0);
            gears[gearNum].remove(0);
            gears[gearNum].add(temp);
        } else if (rollDir == 1) { // 시계 방향 회전
            int temp = gears[gearNum].get(7);
            gears[gearNum].remove(7);
            gears[gearNum].add(0, temp);
        }
    }
}
