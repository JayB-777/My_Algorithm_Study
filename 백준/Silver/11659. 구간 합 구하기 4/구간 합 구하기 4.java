

import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
//        System.out.println(N + " " +  M);

        // 배열입력과 동시에 합배열 생성
        int[] arr = new int[N];
        int[] sumArr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	int input = Integer.parseInt(st.nextToken());
        	
        	if(i == 0) {
        		arr[i] = input;
        		sumArr[i] = input;
        	} else {
        		arr[i] = input;
            	sumArr[i] = sumArr[i - 1] + input;
        	}
        }
        
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(sumArr));
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int startIndex = Integer.parseInt(st.nextToken());
        	int endIndex = Integer.parseInt(st.nextToken());
        	
        	int result = 0;
        	
        	if(startIndex == 1) {
        		result = sumArr[endIndex - 1];
        	} else {
        		result = sumArr[endIndex - 1] - sumArr[startIndex - 2];
        	}
        	
        	System.out.println(result);
        }
        
    }
}









