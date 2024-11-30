class Solution {
    public int[] solution(int num, int total) {
        // 초기값 a 
        int numSum = 0;
        for(int i = 1; i <= num; i++){
            numSum += i;
        }
        //a * num + numSum = total;
        int a = (total - numSum) / num;
        
        int index = 0;
        int[] answer = new int[num];
        for(int i = a + 1; i <= a + num; i++) {
            answer[index] = i;
            index++;
        }
        
        return answer;
    }
}