import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String calculate = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		HashMap<Character, Integer> operPriority = new HashMap<>();
		operPriority.put('*', 2);
		operPriority.put('/', 2);
		
		operPriority.put('+', 1);
		operPriority.put('-', 1);
		
		operPriority.put('(', 0);
		
		for(char cur : calculate.toCharArray()) {
			if(cur <= 'Z' && cur >= 'A') {
				sb.append(cur);
			}else {
				if(cur == '(') {
					stack.add(cur);
				}else if(cur == ')') {
					while(true) {
						if(stack.peek() == '(') {
							stack.pop();
							break;
						}
						
						sb.append(stack.pop());
					}
				}else {
					while(!stack.isEmpty() && operPriority.get(stack.peek()) >= operPriority.get(cur)) {
						sb.append(stack.pop());
					}
					
					stack.add(cur);
				}
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);

	}

}