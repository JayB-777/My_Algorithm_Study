
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static int result = 0;
	public static int index = 0;
    
    public static boolean firstOne(char[] arr){
    	for(int i=0; i<arr.length; i++){
        	if(arr[i] == '1'){
                result++;
                index = i;
            	return true;
            }
        }
        return false;
    }
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			String input = sc.next();
            char[] arr = input.toCharArray();
            
            int result = 0;
            if(firstOne(arr)){
            	for(int i=index+1; i<arr.length; i++){
                	if(arr[i-1] != arr[i]){
                    	result++;
                    }
                }
            }
            
            System.out.printf("#%d %d\n", test_case, result+1);
            
            

		}
	}
}