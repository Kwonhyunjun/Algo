import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<String> stack = new Stack<>();
		Stack<String> calc = new Stack<>();
		
		boolean flag = true;
		
		for(char cur : str.toCharArray()) {
			String elem = String.valueOf(cur);
			
			if(cur == '(' || cur == '[') {
				calc.add(elem);
				stack.add(elem);
			}else {
				if(cur == ')') {
					// 괄호쌍 체크
					if(stack.isEmpty() || !stack.peek().equals("(")) {
						flag = false;
						break;
					}
					
					stack.pop();
					
					int temp = 0;
					while(!calc.isEmpty() && !calc.peek().equals("(")) {
						temp += Integer.parseInt(calc.pop());
					}
					
					calc.pop();
					calc.add((String.valueOf((temp == 0) ? 2 : temp * 2))); 
					
				}else {
					// 괄호쌍 체크
					if(stack.isEmpty() || !stack.peek().equals("[")) {
						flag = false;
						break;
					}
					
					stack.pop();
					
					int temp = 0;
					while(!calc.isEmpty() && !calc.peek().equals("[")) {
						temp += Integer.parseInt(calc.pop());
					}
					
					calc.pop();
					calc.add((String.valueOf((temp == 0) ? 3 : temp * 3))); 
					
				}
			}
		}
		
		if(!stack.isEmpty()) flag = false;
		
		int res = 0;
		if(flag) {
			while(!calc.isEmpty()) {
				res += Integer.parseInt(calc.pop());
			}
		}
		
		System.out.println((!flag) ? 0 : res);

	}

}