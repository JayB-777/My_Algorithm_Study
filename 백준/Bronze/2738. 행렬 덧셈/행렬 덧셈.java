

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int rowSize;
    public static int colSize;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        arr = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                arr[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
