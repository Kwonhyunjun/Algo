import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s); 
        
        int first = Integer.parseInt(st.nextToken());
        int max = first;
        int min = first;
        
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}