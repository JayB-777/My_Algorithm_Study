
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            String[] arr1 = new String[n];
            int[] arr2 = new int[n];
            int sum = 0;
            for(int i=0; i<n; i++){
        		arr1[i] = sc.next();
                arr2[i] = sc.nextInt();
                sum += arr2[i];
            }
			
            int index = 0;
            String[] result = new String[sum];
            for(int i=0; i<n; i++){
            	int j = arr2[i];
                for(int k=0; k<j; k++){
                	result[index] = arr1[i];
                    index++;
                }
            }
            
            System.out.println("#" + test_case);
            for(int i=0; i<result.length; i++){
               	if(i%10==9){
                	System.out.print(result[i] + "\n");
                }else{
                	System.out.print(result[i]);
                }
            }
            System.out.println();
		}
	}
}