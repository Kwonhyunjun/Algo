import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String bomb = br.readLine();
		char last = bomb.charAt(bomb.length()-1);
		
		Stack<Character> stack = new Stack<>();
		Stack<Character> reverse = new Stack<>();
		
		
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			
			stack.add(cur);
			if(last == stack.peek()) {
				if(stack.size() < bomb.length()) continue;
				boolean flag= true;
				
				for(int j=bomb.length()-1; j>=0; j--) {
					char check = stack.pop();
					reverse.add(check);
					if(check != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if(!flag) {
					while(!reverse.isEmpty()) {
						stack.add(reverse.pop());
					}
				}else {
					reverse.clear();
				}
			}
			
		}

		
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			for(char cur : stack) {
				sb.append(cur);
			}
			System.out.println(sb);
		}
		
		

	}

}