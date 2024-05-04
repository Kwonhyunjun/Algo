import java.util.*; 

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char c = s.charAt(0); 
        
        String str = ""; 
        
        if(c == '+'){
            str = s.substring(1, s.length());
            answer += Integer.parseInt(str); 
        }else if(c == '-'){
            str = s.substring(1, s.length());    
            answer -= Integer.parseInt(str); 
        }else{
            answer = Integer.parseInt(s); 
        }
        
        
        return answer;
    }
}