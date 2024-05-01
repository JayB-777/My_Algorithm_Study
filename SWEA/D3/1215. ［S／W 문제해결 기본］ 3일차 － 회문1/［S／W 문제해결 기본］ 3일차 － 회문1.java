
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// [S/W 문제해결 기본] 3일차 - 회문1
public class Solution {
    static char[][] map = new char[8][8]; // 8*8 배열 생성

    public static boolean palindrome(StringBuffer sb) {
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        sb.reverse();
        if (str1.equals(str2))
            return true;
        return false;
    }

    public static int findPalindrome(char[][] arr, int len) {
        int ans = 0;
        // 가로줄 회문 찾기
        for (int i = 0; i < 8; i++) {
            StringBuffer rowSb = new StringBuffer();
            for (int j = 0; j < 8; j++) {
                rowSb.append(map[i][j]);
                if (rowSb.length() > len) {
                    rowSb.delete(0, 1);
                }
                if (rowSb.length() == len && palindrome(rowSb)) {
                    ans++;
                }
            }
        }
        // 세로줄 회문 찾기
        for (int j = 0; j < 8; j++) {
            StringBuffer colSb = new StringBuffer();
            for (int i = 0; i < 8; i++) {
                colSb.append(map[i][j]);
                if (colSb.length() > len) {
                    colSb.delete(0, 1);
                }
                if (colSb.length() == len && palindrome(colSb)) {
                    ans++;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int len = sc.nextInt();

            for (int i = 0; i < 8; i++) {
                map[i] = sc.next().toCharArray();
            }

            int ans = findPalindrome(map, len);
            System.out.printf("#%d %d\n", t, ans);
        }
    }
}