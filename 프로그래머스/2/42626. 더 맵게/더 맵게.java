import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scov : scoville) {
            pq.offer(scov);
        }


        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();  
            int second = pq.poll(); 
            int mixScov = first + second * 2;

            pq.offer(mixScov);
            answer++;
        }


        return pq.peek() >= K ? answer : -1;
    }
}