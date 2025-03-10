

import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        
        int result = 0;
        for(int i = 0; i < N; i++) {
        	result += arr[i] - '0';
        }
        
        System.out.println(result);
        
    }
}