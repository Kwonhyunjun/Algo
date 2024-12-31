import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        
        boolean flag = true;
        for(char cur : s.toCharArray()){
            if(cur == ' '){
                flag = true; 
                sb.append(cur); 
                continue; 
            }
            
            if(flag){
                sb.append(String.valueOf(cur).toUpperCase());
                flag = false;
            }else{
                sb.append(String.valueOf(cur).toLowerCase());
            }
            
            
        }
        
//         while(st.hasMoreTokens()){
//             String str = st.nextToken();
            
//             String first = str.substring(0, 1);
//             String rest = str.substring(1);
//             sb.append(first.toUpperCase()).append(rest.toLowerCase()).append(" ");
//         }
        
//         sb.setLength(sb.length()-1);
        answer = sb.toString();
        
        return answer;
    }
}