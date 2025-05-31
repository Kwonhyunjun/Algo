import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		long answer = 0; 
		int cnt = 1; 
		
		while(!pq.isEmpty()) {
			int expected = pq.poll();
			
			answer += Math.abs(cnt - expected);
			cnt++; 
		}

		System.out.println(answer); 
	}

}