

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] handCard = new int[N];
        for (int i = 0; i < N; i++) {
            handCard[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        LinkedHashMap<Integer, Integer> card = new LinkedHashMap<>();
        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();
            card.put(key, 0);
        }

        for (int i = 0; i < N; i++) {
            if (card.containsKey(handCard[i])) {
                card.replace(handCard[i], 0, 1);
            }
        }

        Iterator<Integer> iterator = card.values().iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
