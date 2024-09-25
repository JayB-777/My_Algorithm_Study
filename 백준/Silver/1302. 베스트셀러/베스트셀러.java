

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();
            hashMap.put(bookName, hashMap.getOrDefault(bookName, 0) + 1);
        }

        String maxSoldBookName = solution(hashMap);
        System.out.println(maxSoldBookName);
    }

    private static String solution(HashMap<String, Integer> hashMap) {
        int maxValue = 0;
        List<String> maxBookNameArr = new ArrayList<>();

        for (String bookName : hashMap.keySet()) {
            int bookValue = hashMap.get(bookName);
            if (bookValue > maxValue) {
                maxValue = bookValue;
                maxBookNameArr.clear();
                maxBookNameArr.add(bookName);
            } else if (bookValue == maxValue) {
                maxBookNameArr.add(bookName);
            }
        }

        Collections.sort(maxBookNameArr);

        return maxBookNameArr.get(0);
    }
}