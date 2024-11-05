import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arrayS = s.split(" ", -1);
        
        for(int j = 0; j < arrayS.length; j++){
            System.out.println(arrayS[j]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayS.length; i++) {
            String current = arrayS[i];
            
            if (!current.isEmpty()) { 
                sb.append(current.substring(0, 1).toUpperCase())
                  .append(current.substring(1).toLowerCase());
            }
            
            if (i < arrayS.length - 1) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}