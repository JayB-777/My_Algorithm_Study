import java.util.*;


public class Solution {
	public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
        
		for (int i = 1; i <= test_case; i++) {
			int N = sc.nextInt();
			String str = sc.next();
			
			boolean isSame = false;
			
			if (N % 2 == 0) {
				for (int j = 0; j <  N / 2; j++) {
					if (str.charAt(j) == str.charAt(j +  N / 2)) {
						isSame = true;
					}
					else {
						isSame = false;
						break;
					}
				}
			}
			else {
				isSame = false;
			}
			
			if (isSame) {
				System.out.println("#" + i + " " + "Yes");
			}
			else if(!isSame) {
				System.out.println("#" + i + " " + "No");
			}
		}
	}
}