import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        HashSet<Float> set = new HashSet<>();
        HashMap<Float, Long> map = new HashMap<>();
        PriorityQueue<Float> pq = new PriorityQueue<>(); 
        
        for(int weight : weights){
            if(set.add((float) weight)){
                pq.add((float) weight);   
            } 
            map.put((float) weight, map.getOrDefault((float)weight, 0L)+1); 
        }
        
        while(!pq.isEmpty()){
            float key = pq.poll(); 
            long n = map.get(key);
            
            // System.out.println("key : " +key); 
            // System.out.println(n);
            if(n > 1){
                answer += (n * (n-1)) / 2; 
                // System.out.println((n * (n-1)) / 2);
            }
            
            float a = key/2 * 3; 
            // System.out.println(a);
            if(map.get(a) != null){
                long m = map.get(a);
                // System.out.printf("[%f, %d] [%f, %d] -> %d\n", key, n, a, m, n*m);
                answer += n * m; 
            }
            
            a = key/3 * 4; 
            // System.out.println(a);
            if(map.get(a) != null){
                long m = map.get(a);
                // System.out.printf("[%f, %d] [%f, %d] -> %d\n", key, n, a, m, n*m);
                answer += n * m; 
            }
            
            a = key*2; 
            // System.out.println(a);
            if(map.get(a) != null){
                long m = map.get(a);
                // System.out.printf("[%f, %d] [%f, %d] -> %d\n", key, n, a, m, n*m);
                answer += n * m; 
            }
            
        }
        
        // System.out.println((int) (100 * (float) 3/2));
        
        return answer;
    }
}