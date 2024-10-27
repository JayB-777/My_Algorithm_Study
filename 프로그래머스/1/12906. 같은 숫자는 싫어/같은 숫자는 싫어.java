import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int previous = -1;  
        for (int num : arr) {
            if (num != previous) { 
                list.add(num);
                previous = num;
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }

        return result;
    }
}