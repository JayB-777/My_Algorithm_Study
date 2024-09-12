

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            int length = (int) Math.pow(3, N);
            char[] result = new char[length];

            for (int i = 0; i < length; i++) {
                result[i] = '-';
            }

            cantorSet(result, 0, length);
            System.out.println(result);
        }
    }

    private static void cantorSet(char[] result, int start, int length) {
        if (length == 1) {
            return;
        }

        int size = length / 3;

        for (int i = start + size; i < start + size * 2; i++) {
            result[i] = ' ';
        }

        cantorSet(result, start, size);
        cantorSet(result, start + 2 * size, size);
    }
}
