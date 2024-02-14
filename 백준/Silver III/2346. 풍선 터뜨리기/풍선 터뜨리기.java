

import java.util.*;

public class Main {

    public static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Pair> balloonDeque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int value = sc.nextInt();
            balloonDeque.add(new Pair(i, value));
        }

        StringBuilder sb = new StringBuilder();
        Pair firstBalloon = balloonDeque.pollFirst();
        sb.append(firstBalloon.index).append(" ");
        int value = firstBalloon.value;

        while (!balloonDeque.isEmpty()) {
            if (value > 0) {
                for (int j = 0; j < value - 1; j++) {
                    balloonDeque.addLast(balloonDeque.pollFirst());
                }
                Pair balloon = balloonDeque.pollFirst();
                value = balloon.value;
                sb.append(balloon.index).append(" ");
            } else {
                for (int j = 0; j < Math.abs(value) - 1; j++) {
                    balloonDeque.addFirst(balloonDeque.pollLast());
                }
                Pair balloon = balloonDeque.pollLast();
                value = balloon.value;
                sb.append(balloon.index).append(" ");
            }
        }

        System.out.println(sb);
    }
}
