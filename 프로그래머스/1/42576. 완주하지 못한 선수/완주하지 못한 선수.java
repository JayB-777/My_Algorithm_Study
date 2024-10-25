import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String result = "";
        
        HashMap<String, Integer> hashmap = new HashMap<>();
        for(String participantParts : participant){
            hashmap.put(participantParts, hashmap.getOrDefault(participantParts, 0) + 1);
        }
        
        
        for(String completionParts : completion){
            hashmap.replace(completionParts, hashmap.get(completionParts) - 1);
        }
        
        for(String participantParts : participant){
            if (hashmap.get(participantParts) > 0){
                result = participantParts;
            }
        }

        return result;
    }
}