

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String[] arr = new String[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.next();
        }
        sc.close();

        for (int i = 0; i < num; i++) {
            if (arr[i].isEmpty()) {
                System.out.println(arr[i] + arr[i]);
            } else {
                System.out.println(arr[i].charAt(0) + arr[i].substring(arr[i].length() - 1));
            }
        }
    }
}
