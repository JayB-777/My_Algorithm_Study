import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resultList = new ArrayList<>();
        
        int n = progresses.length;
        int[] daysLeft = new int[n];
        
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            daysLeft[i] = (int) Math.ceil((double) remain / speeds[i]);
        }

        int currentDay = daysLeft[0];
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (daysLeft[i] <= currentDay) {
                count++;  
            } else {
                resultList.add(count); 
                count = 1;  
                currentDay = daysLeft[i];
            }
        }
        resultList.add(count);  
        
        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}