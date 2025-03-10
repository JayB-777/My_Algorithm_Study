

import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	int count = 0;
    	
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	int startIndex = 0;
    	int endIndex = N - 1;
    	
    	while(startIndex < endIndex) {
    		int sum = arr[startIndex] + arr[endIndex];
    		if( sum == M) {
    			count++;
    			startIndex++;
    			endIndex--;
    		} else if(sum < M) {
    			startIndex++;
    		} else {
    			endIndex--;
    		}
    	}
    	
//    	System.out.println(Arrays.toString(arr));
    	System.out.println(count);
    	
    }
}