

import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String argas[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			hashmap.put(num, num);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int inputNum = Integer.parseInt(st.nextToken());
			if(hashmap.containsKey(inputNum)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
		
	}
}