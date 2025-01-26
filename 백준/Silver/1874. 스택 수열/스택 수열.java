import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack();
		
		int idx = 0;
		int num = 1;
		
		while(num <= N) {
			stack.add(num++);
			sb.append("+").append("\n");
			
			while(!stack.isEmpty() && (stack.peek() == arr[idx])) {
				idx++;
				stack.pop(); 
				sb.append("-").append("\n");
			}
		}
		
		String answer = (stack.size() == 0) ? sb.toString() : "NO"; 
		
		System.out.println(answer);

	}

}