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
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");
			int n = sc.nextInt();
            if (n < 3) {
            	sb.append(0);
                System.out.println(sb);
            } else {
	            sb.append(n/3);
				System.out.println(sb);

            }
            
		}
	}
}