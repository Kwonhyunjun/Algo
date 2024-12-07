import java.util.*; 

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
    
        int idx = 0; 
        for(int i=0; i<s.length(); i++){
            String cur = s.substring(i, i+1);
            
            
            if(cur.equals(" ")){
                idx = 0; 
                sb.append(cur);
                continue;
            }
            
            // System.out.println(cur);
            String change = (idx%2 == 0) ? cur.toUpperCase() : cur.toLowerCase(); 
            sb.append(change);
            idx++; 
        }
        
        answer = sb.toString(); 
        return answer;
    }
}