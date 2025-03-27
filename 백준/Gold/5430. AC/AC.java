import java.io.*;
import java.util.*;

public class Main {
	
	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String command = br.readLine();
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			Deque<Integer> deque = new LinkedList<>();
			
			String array = br.readLine();
			st = new StringTokenizer(array.substring(1, array.length()-1), ",");
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				deque.offerLast(arr[i]);
			}
			
			boolean occurError = false;
			boolean isFirst = true;
			
			for(char curCommand : command.toCharArray()) {
				if(curCommand == 'R') {
					isFirst = !isFirst;
				}else {
					if(deque.size() == 0) {
						sb.append("error").append("\n");
						occurError = true; 
						break; 
					}
					
					if(isFirst) {
						deque.pollFirst();
					}else {
						deque.pollLast();
					}
				}
			}
			
			if(!occurError) {
				if(deque.size() == 0) {
					sb.append("[]").append("\n");
					
				}else {					
					sb.append("[");
					
					if(isFirst) {
						
					}
					while(!deque.isEmpty()) {
						if(isFirst) {
							sb.append(deque.pollFirst()).append(",");
						}else {
							sb.append(deque.pollLast()).append(",");
						}
					}
					sb.setLength(sb.length()-1);
					sb.append("]").append("\n");
				}
			}
		}
		
		System.out.println(sb);

	}

}