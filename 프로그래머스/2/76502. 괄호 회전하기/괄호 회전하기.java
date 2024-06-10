import java.util.*; 

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for(int i=0; i<len; i++){
            Stack<Character> stack = new Stack<>(); 
            boolean isValid = true; 
            
            for(int j=0; j<len; j++){
                char ch = s.charAt((i+j) % len);
                
                if(ch == '[' || ch == '{' || ch == '('){
                    stack.push(ch);
                }else{
                    if(stack.isEmpty()) {
                        isValid = false; 
                        break;
                    }
                    char c = stack.peek();
                    if((ch == ']' && c == '[') ||
                       (ch == '}' && c == '{') ||
                       (ch == ')' && c == '(') 
                      ){
                        stack.pop();
                    } else {
                        isValid = false; 
                        break; 
                    }
                }
            }
                
            if (isValid && stack.isEmpty()){
                answer++; 
            }
        }
        
        return answer;
    }
}