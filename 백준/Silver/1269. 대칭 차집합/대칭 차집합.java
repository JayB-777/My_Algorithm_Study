

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        for (int i = 0; i < n; i++) {
            setA.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            setB.add(sc.nextInt());
        }

        int count = 0;
        for (int i : setB) {
            if (!setA.contains(i)) {
                count++;
            }
        }
        for (int j : setA) {
            if (!setB.contains(j)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
