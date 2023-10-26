import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();

		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				stack.pop();
			}else {
				stack.push(n);
			}
		}
		
		int ans = 0; 
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		
		System.out.println(ans);
	}

}
