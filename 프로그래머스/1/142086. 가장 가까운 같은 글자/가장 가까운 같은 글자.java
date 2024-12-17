import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<26; i++){
            map.put((char) ('a' + i), -1);
        }
        
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            answer[i] = (map.get(cur) == -1) ? -1 : Math.abs(i - map.get(cur));
            
            map.put(cur, i);
            
        }
        
        return answer;
    }
}