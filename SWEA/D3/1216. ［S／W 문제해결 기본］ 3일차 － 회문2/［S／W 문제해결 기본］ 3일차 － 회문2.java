import java.util.*;
import java.io.*;

class Solution
{
    public static final int N = 100;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
		{
            int t = Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
			int result = 0;
            
            for(int i = 0; i < N;  i++){
            	String line = br.readLine();
                for(int j = 0; j < N; j++){
                	map[i][j] = line.charAt(j);
                }
            }
            
            // 행 검사
            for(int i = 0; i < N; i++){
            	result = Math.max(result, sol(map[i]));
            }
            
            //열 검사
            for(int i = 0; i < N; i++){
            	char[] col = new char[N];
                for(int j = 0; j < N; j++){
                	col[j] = map[j][i];
                }
               result = Math.max(result, sol(col));
            }
            
            System.out.println("#" + t + " " + result);
		
		}
	}
    
    private static int sol(char[] arr){
    	int maxLength = 1;
        
        for(int start = 0; start < N; start++){
        	for(int end = start; end < N; end++){
                
                // 회문 확인
            	if(isValid(arr, start, end)){
                	maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }
        return maxLength;
    }
    
    private static boolean isValid(char[] target, int start, int end){
    	while(start < end){
        	if(target[start] != target[end]){
            	return false;
            }
            start++;
            end--;
        }
        return true;
    }
}