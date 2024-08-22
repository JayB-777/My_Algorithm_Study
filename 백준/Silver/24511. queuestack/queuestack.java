

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] structureArr = new int[n];
        for (int i = 0; i < n; i++) {
            structureArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] baseArr = new int[n];
        for (int i = 0; i < n; i++) {
            baseArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] inputArr = new int[m];
        for (int i = 0; i < m; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (structureArr[i] == 0) {
                deque.addFirst(baseArr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            deque.add(inputArr[i]);
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
