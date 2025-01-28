import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		int answer = 0;
		
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			
			if(cur == '(') {
				if(str.charAt(i+1) == ')') {
					answer += stack.size();
					i++;
				}else {
					stack.add(cur);
				}
			}else {
				stack.pop();
				answer++;
			}
		}
		
		System.out.println(answer);

	}

}