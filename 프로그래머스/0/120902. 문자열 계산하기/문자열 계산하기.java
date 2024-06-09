import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        // my_string = my_string.replace(" ", "");
        // char[] c = my_string.toCharArray();
        
        String[] s = my_string.split(" ");
        
        System.out.println(Arrays.toString(s));
        
        answer = Integer.parseInt(s[0]); 
        
        String op = s[1];
        
        for(int i=2; i<s.length; i++){
            if(s[i].equals("+") || s[i].equals("-")){
                op = s[i];
                continue;
            }
            
            if(op.equals("+")){
                answer += Integer.parseInt(s[i]); 
            }else{
                answer -= Integer.parseInt(s[i]); 
            }
        }
        
        return answer;
    }
}