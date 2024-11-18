import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        StringBuilder sb = new StringBuilder(String.valueOf(n)); 
        sb.reverse(); 
        
        // System.out.println(sb);
        
        answer = new int[sb.length()];
        
        for(int i=0; i<sb.length(); i++){
            answer[i] = sb.charAt(i)-48;
        }
        
        return answer;
    }
}