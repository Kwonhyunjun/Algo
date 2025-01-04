import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            if(validate(sb.toString())) answer++; 
            String first = sb.substring(0, 1); 
            String rest = sb.substring(1); 
            
            sb.setLength(0); 
            sb.append(rest).append(first);
        }
        
        return answer;
    }
    
    static boolean validate(String str){
        Stack<Character> stack = new Stack<>(); 
        
        for(char c : str.toCharArray()){
            if(c == '[' || c == '(' || c == '{'){
                stack.add(c); 
                continue;
            }
            
            if(stack.isEmpty()) return false;
            
            char top = stack.peek();
            if((top == '[' && c == ']') || (top == '{' && c == '}') || (top == '(' && c == ')')){
                stack.pop(); 
                continue;
            }else{
                return false;
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}