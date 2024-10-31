import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); 
            int M = sc.nextInt(); 
            int[][] grid = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int maxFlies = 0;

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int flyCount = 0;
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            flyCount += grid[i + x][j + y];
                        }
                    }
                    maxFlies = Math.max(maxFlies, flyCount);
                }
            }
            System.out.println("#" + t + " " + maxFlies);
        }
        sc.close();
    }
}