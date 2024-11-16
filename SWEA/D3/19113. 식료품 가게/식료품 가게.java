


import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N * 2; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list); // 정렬된 상태로 탐색
            List<Integer> sales = new ArrayList<>();

            for (int i = 0; i < list.size(); ) {
                int salePrice = list.get(i);
                int price = salePrice / 3 * 4;

                if (list.contains(price)) {
                    sales.add(salePrice);
                    list.remove(i); // salePrice 제거
                    list.remove(Integer.valueOf(price)); // price 제거
                } else {
                    i++;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");

            for (int sale : sales) {
                sb.append(sale).append(" ");
            }

            System.out.println(sb);
        }
    }
}