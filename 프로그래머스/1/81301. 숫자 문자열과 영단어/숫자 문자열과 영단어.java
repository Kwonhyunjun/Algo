import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, List<String>> map = new HashMap<>();
        HashMap<String, Integer> mapper = new HashMap<>();
        String[] digits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
        
        int num = 0;
        for(String digit : digits){
            char key = digit.charAt(0);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }    
            map.get(key).add(digit);
            
            mapper.put(digit, num++);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            // System.out.println(cur);
            
            if(cur >= '0' && cur <= '9'){
                sb.append(cur - '0');
                continue; 
            }
            
            List<String> candidats = map.get(cur);
            
            if(candidats == null){
                continue;
            }
            
            if(candidats.size() == 1){
                String digit = candidats.get(0);
                sb.append(mapper.get(digit));
                i += digit.length()-1; 
            }
            else{
                for(String candidat : candidats){
                    if(i + candidat.length() -1 >= s.length()) continue;
                    // System.out.println((i + candidat.length()));
                    String subStr = s.substring(i, i+candidat.length());
                    // System.out.println(subStr);
                    if(!subStr.equals(candidat)) continue;
                    sb.append(mapper.get(candidat));
                    i += candidat.length()-1; 
                    // System.out.println("size > 1 : " + i);
                }
            }
        }
        
        answer = Integer.parseInt(sb.toString());
        
        return answer;
    }
}