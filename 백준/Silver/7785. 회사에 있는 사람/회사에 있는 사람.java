

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            hashMap.put(name, status);
        }

        solution(hashMap);

    }

    private static void solution(HashMap<String, String> hashMap) {
        List<String> leavedPersonNameArr = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            String status = hashMap.get(key);
            if (status.equals("enter")) {
                leavedPersonNameArr.add(key);
            }
        }

        Collections.sort(leavedPersonNameArr, Collections.reverseOrder());
        for (String leavedPersonName : leavedPersonNameArr) {
            System.out.println(leavedPersonName);
        }
    }
}
