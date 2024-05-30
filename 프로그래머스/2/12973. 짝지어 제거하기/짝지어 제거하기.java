import java.util.*; 

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        if(s.length() == 0){
            return 1;
        }
        
        Stack<Character> stack = new Stack<>(); 
        char[] c = s.toCharArray(); 
        
        stack.add(c[0]);
        
        
        for(int i=1; i<s.length(); i++){
            
            
            char cur = c[i];
            
            if(stack.isEmpty()){
                stack.add(cur); 
                continue;
            }
            
            if(cur == stack.peek()){
                stack.pop(); 
            }else{
                stack.add(cur); 
            }
        }
        
        answer = (stack.isEmpty()) ? 1 : 0; 
            
        return answer;
    }
}