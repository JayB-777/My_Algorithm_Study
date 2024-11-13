import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            
            // 배열 입력
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < N; j++){
                	map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int result = 0;
            
            // 열로 변환 후 확인
            for(int i = 0; i < N; i++){
            	int[] col = new int[N];
                for(int j = 0; j < N; j++){
                	col[j] = map[j][i];
                }
                result += countDeadLock(col);
            }    
			System.out.println("#" + test_case + " " + result);
		}
	}
    
    private static int countDeadLock(int[] arr){
        int count = 0;
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        
    	if(arr[0] == 2){
        	arr[0] = 0;
        }
        if(arr[n - 1] == 1){
        	arr[n - 1] = 0;
        }
        
        for(int i = 0; i < n; i++){
        	if(arr[i] == 1 || arr[i] == 2){
            	list.add(arr[i]);
            }
        }
        
        for(int i = 0; i < list.size() - 1; i++){
        	if(list.get(i) == 1 && list.get(i+1) == 2){
            	count++;
            }
        }
        
        return count;
    }
}