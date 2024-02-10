

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        LinkedHashMap<String, String> inOutLog = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String enterOrLeave = sc.next();
            if (enterOrLeave.equals("leave")) {
                inOutLog.replace(name, enterOrLeave);
            } else {
                inOutLog.put(name, enterOrLeave);
            }
        }

        ArrayList<String> answerArr = new ArrayList<>();
        for (Map.Entry<String, String> entry : inOutLog.entrySet()) {
            if (entry.getValue().equals("enter")) {
                answerArr.add(entry.getKey());
            }
        }

        Collections.sort(answerArr, Collections.reverseOrder());
        for (String answer : answerArr) {
            System.out.println(answer);
        }
    }

}
