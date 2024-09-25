

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String inputPw = br.readLine();
            solution(inputPw);
        }

    }

    private static void solution(String inputPw) {

        char[] inputPwToCharArray = inputPw.toCharArray();
        List<Character> result = new LinkedList<>();
        ListIterator<Character> cursor = result.listIterator();

        for (char ch : inputPwToCharArray) {
            if (ch == '<') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                }
            } else if (ch == '>') {
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (ch == '-') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else {
                cursor.add(ch);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (char ch : result) {
            sb.append(ch);
        }

        System.out.println(sb);
    }

}
