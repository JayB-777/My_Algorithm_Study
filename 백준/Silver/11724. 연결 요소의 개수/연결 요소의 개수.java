

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] arrayLists;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arrayLists = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arrayLists[s].add(e);
            arrayLists[e].add(s);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : arrayLists[v]) {
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }

}
