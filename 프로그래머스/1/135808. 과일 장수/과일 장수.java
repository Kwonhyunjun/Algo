import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] scores) throws Exception{
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1-o2));
        for(int score : scores){
            pq.offer(score); 
        }
        
        while(pq.size() >= m){
            int min = k; 
            for(int i=0; i<m; i++){
                min = Math.min(pq.poll(), min);
            }
            
            answer += min * m; 
        }
        
        return answer;
    }
}