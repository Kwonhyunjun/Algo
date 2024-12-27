import java.util.*;

class Solution {
    public int solution(int[] ingredients) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int ingredient : ingredients){
            sb.append(ingredient); 
            
            int len = sb.length();
            if(len < 4) continue;
            String candidat = sb.substring(len-4); 
            if(candidat.equals("1231")){
                answer++; 
                sb.setLength(len-4); 
            }
        }
        
        
        
        return answer;
    }
}