import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		Stack<Character> stack = new Stack();
		int answer = 0; 
		
		for(char c : str.toCharArray()) {
			if(c == '(') {
				stack.add(c);
			}else {
				if(stack.isEmpty()) {
					answer++;
				}else {
					stack.pop();
				}
			}
		}

		answer += stack.size();
		
		System.out.println(answer);
	}

}