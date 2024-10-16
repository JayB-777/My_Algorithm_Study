import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int resultCount = 0;
        
        for(int num : tangerine){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
    
        for(int countMapKey : countMap.keySet()){
            pq.add(countMap.get(countMapKey));
        }
        
        int countMapSum = 0;
        
        while(!pq.isEmpty()){
            if(countMapSum >= k){
                break;
            }
            countMapSum += pq.poll();
            resultCount++;
        }
        
        return resultCount;
    }
}