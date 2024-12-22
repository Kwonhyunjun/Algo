import java.util.*;

class Solution {
    public int solution(int n, int m, int[] sections) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int section : sections){
            pq.offer(section);
        }
        
        while(!pq.isEmpty()){
            
            int end = pq.peek() + m;
            // System.out.println(pq.peek() + " " + end);
            while(!pq.isEmpty() && pq.peek() < end){
                pq.poll();
            }
            answer++; 
            
        }
        
        return answer;
    }
}