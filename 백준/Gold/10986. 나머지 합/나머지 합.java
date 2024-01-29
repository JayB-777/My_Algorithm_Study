

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] arr = new long[N];
        arr[0] = sc.nextInt();

        for (int i = 1; i < N; i++) {
            int inputNum = sc.nextInt();
            arr[i] = arr[i - 1] + inputNum;
        }

        long sum = 0;

        long[] remainderArr = new long[M];
        for (int i = 0; i < N; i++) {
            int remainder = (int) (arr[i] % M);
            if (remainder == 0) {
                sum++;
            }
            remainderArr[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (remainderArr[i] > 1) {
                sum += remainderArr[i] * (remainderArr[i] - 1) / 2;
            }
        }

        System.out.println(sum);

    }

}
