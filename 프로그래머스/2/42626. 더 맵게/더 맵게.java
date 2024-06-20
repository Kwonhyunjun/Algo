import java.util.*; 

class Solution {
    /*
        scoville : Leo가 가진 음식의 스코빌 지수를 담은 배열
        K : 원하는 스코빌 지수  
        
        return 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수
    */
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.add(s); 
        }
        
        while(!pq.isEmpty() && pq.peek() < K){
            if(pq.size() == 1){
                answer = (pq.peek() < K)? -1 : answer;
                break; 
            }
            int a = pq.poll();
            int b = pq.poll(); 
            
            int mix= a + (2*b); 
            
            pq.add(mix); 
            answer++;    
        }
        
        return answer;
    }
}