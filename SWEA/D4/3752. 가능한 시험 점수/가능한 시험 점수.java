

import java.util.*;
import java.io.*;

public class Solution{
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] scores = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			
			Set<Integer> set = new HashSet<>();
			set.add(0);
			
			for(int score : scores) {
				List<Integer> list = new ArrayList<>(set);
				for(int current : list) {
					set.add(score + current);
				}
			}
			
			System.out.println("#" + test_case + " " + set.size());
		}
		
	}
}