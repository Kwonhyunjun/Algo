import java.io.*;
import java.util.*;
	
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1]; 
				}
				
				return o1[0] - o2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			pq.offer(new int[] {b, a});
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			sb.append(cur[1]).append(" ").append(cur[0]).append("\n");
		}
		
		System.out.println(sb);

	}

}