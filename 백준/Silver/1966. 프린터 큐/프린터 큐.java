import java.io.*;
import java.util.*;

public class Main {
	
	static class Data{
		int weight;
		boolean isChecked; 
		
		public Data(int weight, boolean isChecked) {
			this.weight = weight;
			this.isChecked = isChecked; 
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Data> q = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1-o2));
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				
				boolean isChecked = (i==M) ? true : false; 
				int weight = Integer.parseInt(st.nextToken());
				q.offer(new Data(weight, isChecked));
				pq.offer(weight);
			 }
			
			int cnt = 1; 
			
			while(!q.isEmpty()) {
				Data cur = q.poll();
				
				if(cur.weight == pq.peek()) {
					if(cur.isChecked) {
						sb.append(cnt).append("\n");
						break;
					}else {
						cnt++;
						pq.poll();
					}
				}else {
					q.offer(cur);
				}
			}
		}
		
		System.out.println(sb);
	}

}