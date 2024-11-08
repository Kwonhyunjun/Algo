import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
//			sb.append(i).append("\n");
			String str = br.readLine(); 
			Stack<Character> stack = new Stack<>();
			boolean flag = false; 
			
			for(int j=0; j<str.length(); j++) {
				char cur = str.charAt(j); 
				
				if(cur == '(') {
					stack.add(cur); 
					
				}else if(cur == ')') {
					if(stack.isEmpty() || stack.peek() == ')') {
						sb.append("NO").append("\n");
						flag = true; 
						break; 
					}
					
					stack.pop(); 
					
				}
			}
			
			if(flag) continue;
			
			if(!stack.isEmpty()) {
				sb.append("NO").append("\n"); 
			}else {
				sb.append("YES").append("\n");
			}
		}
		
		System.out.println(sb);
		

	}

}