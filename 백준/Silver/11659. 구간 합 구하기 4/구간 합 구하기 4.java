

import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        

        // 배열입력과 동시에 합배열 생성
        long[] sumArr = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }
        
//        System.out.println(Arrays.toString(sumArr));
        
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int startIndex = Integer.parseInt(st.nextToken());
        	int endIndex = Integer.parseInt(st.nextToken());
        	long result = sumArr[endIndex] - sumArr[startIndex - 1];
        	System.out.println(result);
        }
    }
}









