

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<Integer, String> pokemon = new HashMap<>();
        HashMap<String, Integer> reversePokemon = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = sc.next();
            pokemon.put(i, name);
            reversePokemon.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String input = sc.next();
            if (Character.isDigit(input.charAt(0))) {
                int key = Integer.parseInt(input);
                System.out.println(pokemon.get(key));
            } else {
                System.out.println(reversePokemon.get(input));
            }
        }
    }
}
