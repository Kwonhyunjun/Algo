import java.util.*; 

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String[] cloth = clothes[i]; 
            
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1); 
        }
        
        answer = 1; 
        
        for(int num : map.values()){
            // System.out.println(num);
            answer *= (num+1); 
        }
        
        return answer-1;
    }
}