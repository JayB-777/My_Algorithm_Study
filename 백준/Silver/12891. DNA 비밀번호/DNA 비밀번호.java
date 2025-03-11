

import java.util.*;
import java.io.*;

class Main {
	
	static int[] myArr;
	static int[] checkArr;
	static int checkSecret;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] inputCharArray = br.readLine().toCharArray();
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < checkArr.length; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) {
				checkSecret++;
			}
		}
		
		// 초기 검사 index 0 ~ P -1 
		for(int i = 0; i < P; i++) {
			Add(inputCharArray[i]);
		}
		if(checkSecret == 4) {
			result++;
		}
		// 초기 검사 끝
		
		// 슬라이딩 윈도우
		for(int i = P; i < S; i++) {
			int j = i - P;
			Add(inputCharArray[i]);
			Remove(inputCharArray[j]);
			if(checkSecret == 4) {
				result++;
			}
		}
		// 슬라이딩 윈도우 끝
		
		System.out.println(result);
		br.close();
		
	}
	
	public static void Add(char c) {
		switch(c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0]) checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1]) checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2]) checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3]) checkSecret++;
			break;
		}
	}
	
	public static void Remove(char c) {
		switch(c) {
		case 'A':
			if(myArr[0] == checkArr[0]) checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) checkSecret--;
			myArr[3]--;
			break;
		}
	}
}