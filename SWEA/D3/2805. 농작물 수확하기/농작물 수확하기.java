
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

    public static int getBenefit(int[][] form) {
        int benefit = 0;
        int formSize = form.length;
        int mid = formSize / 2;

        // 마름모의 위쪽 부분을 더합니다.
        for (int i = 0; i <= mid; i++) {
            for (int j = mid - i; j <= mid + i; j++) {
                benefit += form[i][j];
            }
        }

        // 마름모의 아래쪽 부분을 더합니다.
        for (int i = mid + 1; i < formSize; i++) {
            for (int j = mid - (formSize - 1 - i); j <= mid + (formSize - 1 - i); j++) {
                benefit += form[i][j];
            }
        }

        return benefit;
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int formSize = sc.nextInt();
            int[][] form = new int[formSize][formSize];

            for (int i = 0; i < formSize; i++) {
                String input = sc.next();
                for (int j = 0; j < formSize; j++) {
                    form[i][j] = Integer.parseInt(input.substring(j, j + 1));
                }
            }

            System.out.println("#" + test_case + " " + getBenefit(form));
        }
    }
}