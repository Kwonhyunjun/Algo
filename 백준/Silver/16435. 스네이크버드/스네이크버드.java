import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		while(!pq.isEmpty() && pq.peek() <= L) {
			pq.poll();
			L++; 
		}
		
		System.out.println(L);

	}

}