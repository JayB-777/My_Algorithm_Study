import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int[][] arr = new int[100][100];

            int result = 0;
            int testCase = scanner.nextInt();
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = scanner.nextInt(); 
                }
            }

            int maxCol = 0;
            int maxRow = 0;
            int maxLeftDiagonalSum = 0;
            int maxRightDiagonalSum = 0;

            for (int j = 0; j < 100; j++) {
                int colSum = 0;
                int rowSum = 0;


                maxLeftDiagonalSum += arr[j][j];
                maxRightDiagonalSum += arr[j][99 - j];

                for (int k = 0; k < 100; k++) {
                    colSum += arr[j][k];
                    rowSum += arr[k][j];
                }

                if (colSum > maxCol) {
                    maxCol = colSum;
                }

                if (rowSum > maxRow) {
                    maxRow = rowSum;
                }
            }


            result = Math.max(Math.max(maxCol, maxRow), Math.max(maxLeftDiagonalSum, maxRightDiagonalSum));

            System.out.println("#" + testCase + " " + result);
        }

        scanner.close();
    }
}
