import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        int gcdA = findArrayGCD(arrayA);
        int gcdB = findArrayGCD(arrayB);
        int resultA = 0;
        int resultB = 0;

        if (gcdA > 1 && !canDivideAll(arrayB, gcdA)) {
            resultA = gcdA;
        }

        if (gcdB > 1 && !canDivideAll(arrayA, gcdB)) {
            resultB = gcdB;
        }
        
        if(resultA == 0 && resultB ==0){
            return 0;
        }
        
        return Math.max(resultA, resultB);
    }

    private int findArrayGCD(int[] array) {
        int resultGCD = array[0];
        for (int i = 1; i < array.length; i++) {
            resultGCD = gcd(resultGCD, array[i]);
        }
        return resultGCD;
    }

    private boolean canDivideAll(int[] array, int divisor) {
        for (int num : array) {
            if (num % divisor == 0) {
                return true;
            }
        }
        return false;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}