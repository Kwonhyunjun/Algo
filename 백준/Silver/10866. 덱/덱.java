import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			switch(command) {
			case "push_front" :
				deque.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back" :
				deque.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
				sb.append("\n");
				break;
			case "pop_back" :
				sb.append(deque.isEmpty() ? -1 : deque.pollLast());
				sb.append("\n");
				break;
			case "size" :
				sb.append(deque.size());
				sb.append("\n");
				break;
			case "empty" :
				sb.append(deque.isEmpty() ? 1 : 0);
				sb.append("\n");
				break;
			case "front" :
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
				sb.append("\n");
				break;
			case "back" :
				sb.append(deque.isEmpty() ? -1 : deque.peekLast());
				sb.append("\n");
				break;
			}
		}
		
		System.out.println(sb);
	}

}