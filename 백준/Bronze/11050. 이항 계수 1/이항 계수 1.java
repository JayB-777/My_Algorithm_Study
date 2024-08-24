

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        int result = factorial(n) / (factorial(k) * factorial(n - k));
        System.out.println(result);
    }

    static int factorial(int num) {
        int result = 1;

        for (int i = 2; i <= num; i++) {
            result = result * i;
        }
        return result;
    }
}
