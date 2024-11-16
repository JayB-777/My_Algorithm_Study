

import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main (String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 주머니 개
			int K = Integer.parseInt(st.nextToken()); // 나눠줄 주머니 개
			int[] candyNum = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				candyNum[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = sol(candyNum, K);
			System.out.println("#" + test_case + " " + result);
		}

		
	}
	
	private static int sol(int[] candyNum, int K) {
		int n = candyNum.length;
		Arrays.sort(candyNum); 
	    int minDifference = Integer.MAX_VALUE; 

	    for (int i = 0; i <= n - K; i++) {
	        int difference = candyNum[i + K - 1] - candyNum[i]; 
	        minDifference = Math.min(minDifference, difference);
	    }

	    return minDifference;
		
	}
	

}
