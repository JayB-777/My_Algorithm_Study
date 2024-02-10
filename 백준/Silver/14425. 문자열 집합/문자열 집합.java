import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            String word = sc.next();
            if (wordMap.containsKey(word)) {
                count++;
            }
        }

        System.out.print(count);
    }
}
