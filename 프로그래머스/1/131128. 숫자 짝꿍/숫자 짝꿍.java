import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        ArrayList<Integer> common = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : Y.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1); 
        }
        
        for(char c : X.toCharArray()){
            if(map.containsKey(c)){
                common.add(c - '0'); 
                int minus = map.get(c)-1;
                map.put(c, minus);
                if(minus == 0) map.remove(c);
            }
        }
        
        if(common.isEmpty()){
            answer = "-1"; 
        }else{
            Collections.sort(common, (o1, o2) -> -(o1-o2)); 
            if(common.get(0) == 0){
                answer = "0"; 
            }else{
                StringBuilder sb = new StringBuilder(); 
                for(int num : common){
                    sb.append(num);
                }
                
                answer = sb.toString();
            }
        }
        
        
        
        return answer;
    }
}