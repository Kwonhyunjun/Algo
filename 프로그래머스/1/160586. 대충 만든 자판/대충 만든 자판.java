import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int[] indexes = new int[26];
        Arrays.fill(indexes, Integer.MAX_VALUE);
        
        for(String str : keymap){
            for(int i=0; i<str.length(); i++){
                char cur = str.charAt(i);
                
                int idx = cur - 'A'; 
                indexes[idx] = Math.min(indexes[idx], i+1);
            }
        }
        
        int num = 0;
        for(String target : targets){
            int cnt = 0;
            boolean flag = true; 
            for(int i=0; i<target.length(); i++){
                char cur = target.charAt(i);
                int idx = cur - 'A';
                
                if(indexes[idx] == Integer.MAX_VALUE){
                    answer[num++] = -1; 
                    flag = false;
                    break; 
                }else{
                    cnt += indexes[idx]; 
                }
            }
            if(flag) answer[num++] = cnt; 
        }
        
        return answer;
    }
}