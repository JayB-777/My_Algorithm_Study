class Solution {
    private int count = 0;

    public int solution(int n) {
        int[] queens = new int[n]; 
        placeQueens(queens, 0, n); 
        return count;
    }

    private void placeQueens(int[] queens, int row, int n) {
        if (row == n) { 
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                placeQueens(queens, row + 1, n); 
            }
        }
    }

    private boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}