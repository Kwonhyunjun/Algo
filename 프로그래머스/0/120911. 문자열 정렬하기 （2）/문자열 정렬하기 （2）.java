import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        my_string = my_string.toLowerCase(); 
        
//         StringBuilder sb = new StringBuilder();
        
//         sb.append(my_string).sort(); 
        
        char[] arr = my_string.toCharArray(); 
        
        Arrays.sort(arr); 
        
        answer = new String(arr);
        
        return answer;
    }
}