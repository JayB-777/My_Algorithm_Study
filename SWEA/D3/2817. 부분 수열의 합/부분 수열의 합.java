import java.util.Scanner;

public class Solution {
    static int N, K, count, arr[];

    public static void findSubset(int index, int sum) {
        if (sum == K) {
            count++;
            return;
        }
        if (index == N || sum > K) {
            return;
        }

        findSubset(index + 1, sum + arr[index]);
        findSubset(index + 1, sum);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            count = 0;
            findSubset(0, 0);
            System.out.println("#" + test_case + " " + count);
        }
    }
}