import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int goalCaseNum = sc.nextInt();
            int numOfBuy = sc.nextInt();

            String[] goalCase = new String[goalCaseNum];
            int[] goalMoney = new int[goalCaseNum];
            String[] buyCase = new String[numOfBuy];

            for (int i = 0; i < goalCaseNum; i++) {
                goalCase[i] = sc.next();
                goalMoney[i] = sc.nextInt();
            }

            for (int i = 0; i < numOfBuy; i++) {
                buyCase[i] = sc.next();
            }

            int result = 0;
            for (int i = 0; i < numOfBuy; i++) {
                for (int j = 0; j < goalCaseNum; j++) {
                    String base = buyCase[i];
                    String compare = goalCase[j];
                    if (isTrue(base, compare)) {
                        result += goalMoney[j];
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);
        }

    }

    static boolean isTrue(String base, String compare) {
        for (int i = 0; i < base.length(); i++) {
            if (compare.charAt(i) == '*') {
                continue;
            }
            if (base.charAt(i) != compare.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}