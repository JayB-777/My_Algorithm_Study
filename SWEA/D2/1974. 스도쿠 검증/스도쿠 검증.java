import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] map = new int[9][9];
            
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            boolean valid = true;
            
            // 행, 열 확인
            for (int i = 0; i < 9; i++) {
                if (!isValid(map[i]) || !isValid(getColumn(map, i))) {
                    valid = false;
                    break;
                }
            }
            
            // 행, 열 통과 시 3x3 확인
            if (valid) {
                for (int gridRow = 0; gridRow < 3; gridRow++) {
                    for (int gridCol = 0; gridCol < 3; gridCol++) {
                        if (!isValid(getMiniMap(map, gridRow, gridCol))) {
                            valid = false;
                            break;
                        }
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + (valid ? 1 : 0));
        }
    }


    private static boolean isValid(int[] arr) {
        boolean[] seen = new boolean[9];
        for(int num : arr){
        	if(num <1 || num > 9 || seen[num - 1]){
            	return false;
            }
            seen[num - 1] = true;
        }
        return true;
    }


    private static int[] getColumn(int[][] map, int colIndex) {
        int[] col = new int[9];
        for (int i = 0; i < 9; i++) {
            col[i] = map[i][colIndex];
        }
        return col;
    }

    private static int[] getMiniMap(int[][] map, int gridRow, int gridCol) {
        int[] miniMap = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                miniMap[index++] = map[gridRow * 3 + i][gridCol * 3 + j];
            }
        }
        return miniMap;
    }
}