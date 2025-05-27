import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
        for(int work : works){
            pq.offer(work);
        }
        
        while(n-- > 0){
            if(pq.isEmpty()) break;
            
            int rest = pq.poll()-1;
            if(rest > 0) pq.offer(rest);
            
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2); 
        }
        
        
        
        return answer;
    }
}