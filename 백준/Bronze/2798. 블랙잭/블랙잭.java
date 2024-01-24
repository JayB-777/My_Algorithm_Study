

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int card_num = sc.nextInt();
        int goal_num = sc.nextInt();

        int[] deck = new int[card_num];
        for (int i = 0; i < card_num; i++) {
            deck[i] = sc.nextInt();
        }

        int result = search(deck, card_num, goal_num);
        System.out.println(result);

    }

    static int search(int[] deck, int card_num, int goal) {
        int result = 0;

        for (int i = 0; i < card_num - 2; i++) {
            for (int j = i + 1; j < card_num - 1; j++) {
                for (int k = j + 1; k < card_num; k++) {
                    int temp = deck[i] + deck[j] + deck[k];
                    if (temp == goal) {
                        return temp;
                    }
                    if (result < temp && temp < goal) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}
