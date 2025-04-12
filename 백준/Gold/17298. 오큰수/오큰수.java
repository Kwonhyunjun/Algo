import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int[] nge = new int[N];
		
		Arrays.fill(nge, -1);
		stack.add(arr[N-1]);
		
		for(int i=N-2; i>=0; i--) {
			int cur = arr[i];
			
			while(!stack.isEmpty() && stack.peek() <= cur) {
				stack.pop();
			}
			
			nge[i] = (stack.isEmpty()) ? -1 : stack.peek();
			
			stack.add(cur);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num : nge) {
			sb.append(num).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}

}