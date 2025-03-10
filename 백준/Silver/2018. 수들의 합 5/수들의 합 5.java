

import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int sum = 1;
    	int count = 1;
    	int startIndex = 1;
    	int endIndex = 1;
    	
    	while(endIndex != N) {
    		if(sum == N) {
    			count++;
    			endIndex++;
    			sum += endIndex;
    		} else if(sum > N) {
    			sum -= startIndex;
    			startIndex++;
    		} else  {
    			endIndex++;
    			sum += endIndex;
    		}
    	}
    	System.out.println(count);
    	
    }
}