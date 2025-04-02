import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		Queue<Integer> q = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		Stack<Integer> stack = new Stack<>();

		int cur = 1; 
		
		while(true) {
			
			while(!stack.isEmpty() && stack.peek() == cur) {
				stack.pop();
				cur++;
			}
			
			
			while(!q.isEmpty() && q.peek() != cur) {
				stack.add(q.poll());
			}
			
			if(!q.isEmpty() && q.peek() == cur) {
				q.poll();
				cur++;
			}
			
			
			if((q.isEmpty() && stack.isEmpty()) || (q.isEmpty() && stack.peek() != cur)) break;
		}
		
		if(q.isEmpty() && stack.isEmpty()) {
			System.out.println("Nice");
		}else {
			System.out.println("Sad");
		}
	}

}