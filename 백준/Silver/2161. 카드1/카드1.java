import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			deque.offerLast(i);
		}
		
		while(deque.size() > 1) {
			sb.append(deque.pollFirst()).append(" ");
			deque.offerLast(deque.pollFirst());
		}
		
		sb.append(deque.pollFirst());
		
		System.out.println(sb);

	}

}