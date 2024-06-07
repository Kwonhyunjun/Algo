import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder(); 
        
        // System.out.println('A'-0);
        // System.out.println('Z'-0);
        // System.out.println('a'-0);
        // System.out.println('z'-0);
        // System.out.println('0'-0);
        // System.out.println('1'-0);
        // System.out.println('9'-0);
        
//         while(st.hasMoreTokens()){
//             String cur = st.nextToken(); 
            
//             int start = cur.charAt(0) - 0;
            
//             if(start >= 48 && start < 58){
//                 sb.append(cur);
//             }else{ 
//                 // System.out.println(String.valueOf(cur.charAt(0)).toUpperCase()); 
//                 String str = String.valueOf(cur.charAt(0)).toUpperCase(); 
//                 String rest = cur.substring(1).toLowerCase(); 
//                 // System.out.println(rest); 
//                 sb.append(str).append(rest); 
//             }
//             sb.append(" ");
//         }
        
//         // System.out.println(sb); 
//         sb.setLength(sb.length()-1);
//         answer = sb.toString();
        
        String token = ""; 
        
        for(char cur : s.toCharArray()){

            if(cur == ' '){
                sb.append(token).append(" "); 
                token = ""; 
                continue;
            }
            
            if("".equals(token)){
                token += String.valueOf(cur).toUpperCase();
            }else{
                token += String.valueOf(cur).toLowerCase();
            }
        }
        
        sb.append(token); 
        
        System.out.println(sb); 
        
        answer = sb.toString(); 
        
        return answer;
    }
}