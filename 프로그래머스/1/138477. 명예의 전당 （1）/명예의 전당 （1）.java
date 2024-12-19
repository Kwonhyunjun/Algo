import java.util.*;

class Solution {
    public int[] solution(int k, int[] scores) {
        int[] answer = new int[scores.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int idx = 0;
        for(int score : scores){
            if(pq.size() < k){
                pq.offer(score);
                
            }else{
                if(score > pq.peek()){
                    pq.poll();
                    pq.offer(score);
                }
            }
            
            answer[idx++] = pq.peek();
            
        }
        
        return answer;
    }
}