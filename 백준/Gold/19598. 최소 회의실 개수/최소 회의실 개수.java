import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<int[]> meetings = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			meetings.add(new int[] {a, b});
		}
		
		Collections.sort(meetings, (o1, o2) -> o1[0]-o2[0]);
		
		pq.offer(meetings.get(0)[1]);
		
		for(int i=1; i<N; i++) {
			if(pq.peek() <= meetings.get(i)[0]) {
				pq.poll(); 
			}
			
			pq.offer(meetings.get(i)[1]);
		}
		
		System.out.println(pq.size());

	}

}