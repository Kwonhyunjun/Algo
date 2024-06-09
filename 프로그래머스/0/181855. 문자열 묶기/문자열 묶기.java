import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        
        for(String str : strArr){
            int len = str.length(); 
            
            map.put(len, map.getOrDefault(len, 0)+1); 
        }
        
        
        answer = Collections.max(map.values());
        
        return answer;
    }
}