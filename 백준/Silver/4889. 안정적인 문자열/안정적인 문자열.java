import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int T = 1; 
		while(true) {
			String str = br.readLine(); 
			
			if(str.charAt(0) == '-') break;
			Stack<Character> stack = new Stack();
			int cnt = 0; 
			
			for(int i=0; i<str.length(); i++) {
				char cur = str.charAt(i); 
				
				if(cur == '{') {
					if(i==str.length()-1 && stack.peek()== '{') {
						cnt++;
						stack.pop(); 
					}
					
					stack.push('{'); 
				
				}else if(cur == '}') {
					
					if(stack.isEmpty()) {
						// 스택이 비어있다면
						cnt++; 
						stack.push('{');
					}else{
						if(stack.peek() == '{') {
							stack.pop();
						}else {
							cnt++;
							stack.pop(); 
						}
					}
				}
			}
			
			if(!stack.isEmpty()) {
				cnt += stack.size() / 2; 
			}
			
			
			sb.append(T++).append(". ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}