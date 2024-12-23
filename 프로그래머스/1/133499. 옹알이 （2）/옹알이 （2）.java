import java.util.*;

class Solution {
    public int solution(String[] babblings) {
        int answer = 0;
        String[] cans = new String[]{"aya", "ye", "woo", "ma"};
        HashMap<Character, String> map = new HashMap<>();
        for(String can : cans){
            map.put(can.charAt(0), can);
        }
        
        for(String babbling : babblings){
            int idx = 0; 
            boolean flag = true;
            String prev = ""; 
            
            // System.out.println(babbling);
            
            while(idx < babbling.length()){
                char cur = babbling.charAt(idx); 
                // System.out.println(cur);
                
                if(!map.containsKey(cur)){
                    flag = false;
                    break;
                }
                
                String candidat = map.get(cur);
                if((idx+candidat.length()-1) >= babbling.length()){
                    flag = false;
                    break; 
                }
                
                String sub = babbling.substring(idx, idx+candidat.length()); 
                if(!candidat.equals(sub) || sub.equals(prev)){
                    flag = false;
                    break;
                }
                
                idx += candidat.length();
                prev = sub;
                
            }
            
            if(flag) answer++;
            // System.out.println(flag);
            
        }
        
        
        return answer;
    }
}