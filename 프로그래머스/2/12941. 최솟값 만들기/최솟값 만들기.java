import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        List<Integer> listA = new ArrayList<>();
        for(int a : A){
            listA.add(a);
        }

        List<Integer> listB = new ArrayList<>();
        for(int b : B){
            listB.add(b);
        }
        
        Collections.sort(listA);
        Collections.sort(listB, Collections.reverseOrder());
        
        for(int i = 0; i < A.length; i++){
            answer += listA.get(i) * listB.get(i);
        }

        return answer;
    }
}