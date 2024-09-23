

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] arr = br.readLine().toCharArray();
            System.out.println(solution(arr));
        }

    }

    private static String solution(char[] arr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char character = arr[i];
            if (character == '(') {
                stack.push(character);
            } else if (stack.isEmpty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
