import java.util.*; 

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder(); 
        Stack<Integer> stack = new Stack<>(); 
        
        for(int i=0; i<number.length(); i++){
            int num = number.charAt(i) - 48; 
            
            while(!stack.isEmpty() && k > 0 && stack.peek() < num){
                stack.pop(); 
                k--;
            }
            
            stack.push(num); 
        }
        
        while(k>0){
            stack.pop(); 
            k--; 
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        answer = sb.reverse().toString();
        
        return answer;
    }
}