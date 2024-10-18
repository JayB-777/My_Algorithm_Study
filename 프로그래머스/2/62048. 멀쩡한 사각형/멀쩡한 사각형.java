class Solution {
    public long solution(int w, int h) {
        long totalSquares = (long) w * h; 
        long unusedSquares = (long) w + h - gcd(w, h); 
        
        return totalSquares - unusedSquares; 
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}