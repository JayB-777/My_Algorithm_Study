

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            stringSet.add(sc.next());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (stringSet.contains(sc.next())) {
                count++;
            }
        }

        System.out.print(count);
    }
}
