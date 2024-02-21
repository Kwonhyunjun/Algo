import java.io.*;
import java.util.*;

public class Main {

	static int N, M, d[];
	static ArrayList<Data>[] adjList; 
	
	static class Data implements Comparable<Data>{
		int n; 
		int w; 
		
		public Data(int n, int w) {
			this.n = n;
			this.w = w;
		}
		
		@Override
		public int compareTo(Data o) {
			return this.w - o.w; 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		d = new int[N+1]; 
		Arrays.fill(d, Integer.MAX_VALUE);
		adjList = new ArrayList[N+1]; 
		
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList(); 
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Data(to, weight));
		}
		
		st = new StringTokenizer(br.readLine()); 
		int start = Integer.parseInt(st.nextToken()); 
		int end = Integer.parseInt(st.nextToken()); 
		
		int ans = solve(start, end);  
		System.out.println(ans);
	}

	private static int solve(int start, int end) {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		
		pq.offer(new Data(start, 0)); 
		d[start] = 0; 
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll(); 
			
			if(d[cur.n] != cur.w) continue;
			
			for(Data next : adjList[cur.n]) {
				
				if(d[next.n] <= cur.w + next.w) continue;
				
				d[next.n] = cur.w + next.w; 
				pq.offer(new Data(next.n, cur.w + next.w));
			}
			
		}
		
		
		return d[end];
	}

}