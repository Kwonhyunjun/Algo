import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine()); 
		int[] heights = new int[1_000_001]; 
		Arrays.fill(heights, -1);
		
		st = new StringTokenizer(br.readLine());
		
		int idx = Integer.parseInt(st.nextToken()); 
		int prev = Integer.parseInt(st.nextToken()); 
		int x = 0; 
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			
			
			while(idx < x) {
				heights[idx] = prev;
				idx++; 
			}
			
			prev = Integer.parseInt(st.nextToken());
		}
		
		heights[idx] = prev; 
		
//		System.out.println(Arrays.toString(heights));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
		pq.offer(0);
		idx = 1; 
		int answer = 0; 
		while(true) {
			int cur = heights[idx];
			if(cur == -1) {
				while(pq.peek() > 0) {
					pq.poll();
					answer++;
				}
				break;
			}
			
			if(cur == pq.peek()) {
				idx++; 
			}else if(cur > pq.peek()) {
//				for(int i=pq.peek()+1; i<=cur; i++) {
//					if(pq.contains(i)) continue;
					pq.offer(cur);
//				}
				idx++;
			}else {
				while(!pq.isEmpty() && pq.peek() > cur) {
					pq.poll();
					answer++; 
				}
				
				if(pq.peek() < cur) {
					pq.offer(cur);
				}
				idx++;
			}
		}
		
		System.out.println(answer);

	}

}