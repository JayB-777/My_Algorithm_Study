

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (String s : map.keySet()) {
            if (map.get(s) >= 2) {
                count++;
                sb.append(s).append(",");
            }
        }

        String[] arr = sb.toString().split(",");
        Arrays.sort(arr);

        System.out.println(count);
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
