import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houses.add(new int[]{i, j});
                if (val == 2) chickens.add(new int[]{i, j});
            }
        }

        // 조합 생성과 거리 계산
        generateCombinations(0, 0, new boolean[chickens.size()]);
        System.out.println(result);
    }

    private static void generateCombinations(int index, int selectedCount, boolean[] selected) {
        if (selectedCount == M) {
            result = Math.min(result, calculateDistance(selected));
            return;
        }

        if (index == chickens.size()) return;

        // 현재 치킨집 포함
        selected[index] = true;
        generateCombinations(index + 1, selectedCount + 1, selected);
        // 현재 치킨집 미포함
        selected[index] = false;
        generateCombinations(index + 1, selectedCount, selected);
    }

    private static int calculateDistance(boolean[] selected) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    int[] chicken = chickens.get(i);
                    int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    minDistance = Math.min(minDistance, distance);
                }
            }
            totalDistance += minDistance;
        }

        return totalDistance;
    }
}