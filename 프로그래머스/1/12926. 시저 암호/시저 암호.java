import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] upper = new char[26];
        char[] lower = new char[26]; 
        
        for(int i=0; i<26; i++){
            upper[i] = (char) ('A' + i);
            lower[i] = (char) ('a' + i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == 32){
                sb.append(" ");
                continue; 
            }
            char[] arr = {};
            int offset = 0;
            if(c >= 'a' && c <= 'z'){
               arr = lower;
                offset = 97; 
            }else{
                arr = upper;
                offset = 65; 
            }
            
            
            int idx = (c-offset + n) % 26; 
            sb.append(arr[idx]);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}