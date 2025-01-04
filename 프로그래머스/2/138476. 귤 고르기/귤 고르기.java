import java.util.*;

class Solution {
    static class Data{
        int num, cnt; 
        
        public Data(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }    
    }
    
    public int solution(int k, int[] tangerines) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int tangerine : tangerines){
            map.put(tangerine, map.getOrDefault(tangerine, 0)+1); 
        }
        
        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> -(o1.cnt - o2.cnt)); 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new Data(entry.getKey(), entry.getValue())); 
        }
        
        while(k > 0){
            k -= pq.poll().cnt; 
            answer++; 
        }
        
        return answer;
    }
}