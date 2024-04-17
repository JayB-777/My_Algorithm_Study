
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int numOfIngred, maxCal;
    static int[] tasteScores, calArr;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            numOfIngred = sc.nextInt();
            maxCal = sc.nextInt();

            tasteScores = new int[numOfIngred];
            calArr = new int[numOfIngred];

            for (int i = 0; i < numOfIngred; i++) {
                tasteScores[i] = sc.nextInt();
                calArr[i] = sc.nextInt();
            }
            int result = calculateMaxTaste(0, 0, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(result);
            if (test_case != T) {
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    static int calculateMaxTaste(int ingredientIndex, int totalCalories, int totalTaste) {
        // 현재까지의 칼로리 합계가 최대 칼로리를 초과하면, 이 조합은 무효이므로 0을 반환
        if (totalCalories > maxCal) {
            return 0;
        }
        // 모든 재료를 확인했다면, 현재까지의 맛 점수 합계를 반환
        if (ingredientIndex == numOfIngred) {
            return totalTaste;
        }
        // 현재 재료를 포함하는 경우와 포함하지 않는 경우 중, 맛 점수가 더 높은 경우를 선택
        int maxTaste = Math.max(
                calculateMaxTaste(ingredientIndex + 1, totalCalories + calArr[ingredientIndex],
                        totalTaste + tasteScores[ingredientIndex]), // 현재 재료를 포함하는 경우
                calculateMaxTaste(ingredientIndex + 1, totalCalories, totalTaste) // 현재 재료를 포함하지 않는 경우
        );
        return maxTaste;
    }

}