import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>(); 
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				
				if(c == ')') {
					if(stack.isEmpty()) {
						return false; 
					}
					stack.pop(); 
				}else {
					stack.add(c); 
				}
			}
			
			if(stack.isEmpty()) {
				return true;
			}else {
				return false;
			}
//           boolean answer = true;

// 	        Stack<Character> stack = new Stack<Character>(); 
			
// 			for(int i=0; i<s.length(); i++) {
// 				char c = s.charAt(i);
				
// 				if(stack.isEmpty() && c == ')') {
// 					return false; 
// 				}else {
					
// 				}
				
// 				if(stack.isEmpty()) {
// 					if(c == ')') {
// 						return false; 
// 					}else {
// 						stack.add(c);
// 					}
// 				}else {
// 					if(c == '(') {
// 						stack.add(c);
// 					}else {
// 						if(stack.peek() == '(') {
// 							stack.pop();
// 						}
// 					}
// 				}
				
// 			}
			
// 			if(stack.isEmpty()) {
// 				return true;
// 			}else {
// 				return false;
// 			}
    }
}