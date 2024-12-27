import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(); 
        HashSet<Character> set = new HashSet<>();
        for(char c : skip.toCharArray()){
            set.add(c);
        }
        
        char[] arr = new char[26]; 
        for(int i=0; i<26; i++){
            char cur = (char) ('a' + i); 
            
            arr[i] = cur; 
        }
        
        
        
        for(char c : s.toCharArray()){
            
            int idx = (c - 'a') % 97; 
            
            int cnt = 0;
            while(cnt < index){
                idx = (idx+1) % 26; 
                if(set.contains(arr[idx])) continue; 
                cnt++;
            }
            
            System.out.println(arr[idx]); 
            sb.append(arr[idx]);
        }
        
        answer = sb.toString();

        return answer;
    }
}