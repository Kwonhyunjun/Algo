import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        
        char prev = s.charAt(0);
        int cnt = 1; 
        
        for(int i=1; i<arr.length; i++){
            char cur = arr[i];
            if(prev == cur){
                cnt++;
            }else{
                cnt--; 
                if(cnt == 0){
                    answer++;
                    if(i+1 < arr.length){
                        i++;
                        prev = s.charAt(i);
                        cnt = 1;    
                    }
                }
            }
        }
        
        if(cnt > 0) answer++;
        
        return answer;
    }
}