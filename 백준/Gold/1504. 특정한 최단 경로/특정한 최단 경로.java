import java.io.*;
import java.util.*; 

public class Main {

	static int N, E, dist[], m1, m2;
	static ArrayList<Data>[] adjList; 
	
	static class Data implements Comparable<Data>{
		int n; 
		int w; 
		
		public Data(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Data o) { // public int compare(Data d) {
			return this.w - o.w;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1]; 
		dist = new int[N+1]; 
		
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList<>(); 
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Data(b, c)); 
			adjList[b].add(new Data(a, c)); 
		}
		
		st = new StringTokenizer(br.readLine()); 
		
		m1 = Integer.parseInt(st.nextToken()); 
		m2 = Integer.parseInt(st.nextToken()); 
		
//		System.out.println(solve(1, m1));
//		System.out.println(solve(1, m2));
//		System.out.println(solve(m1, N));
//		System.out.println(solve(m2, N));
//		System.out.println(solve(m1, m2));
//		System.out.println(solve(m2, m1));
	
		int ans = 0; 
		// 1 -> m1 -> m2 -> N
		int a = solve(1, m1); 
		int b = solve(m1, m2); 
		int c = solve(m2, N); 
		
		boolean isAvailable1 = true;
		if(a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE) {
			isAvailable1 = false;
		}
		 
		// 1 -> m2 -> m1 -> N
		int d = solve(1, m2); 
		int e = solve(m2, m1); 
		int f = solve(m1, N); 
		
		boolean isAvailable2 = true;
		if(d == Integer.MAX_VALUE || e == Integer.MAX_VALUE || f == Integer.MAX_VALUE) {
			isAvailable2 = false;
		}		
		
//		System.out.println(isAvailable1);
//		System.out.println(isAvailable2);
		
		if(isAvailable1 && isAvailable2) {
			ans = Math.min((a+b+c), (d+e+f));
		}else if(isAvailable1) {
			ans = a+b+c; 
		}else if(isAvailable2) {
			ans = d+e+f; 
		}else {
			ans = -1; 
		}
		
		System.out.println(ans);
	}
	
	public static int solve(int start, int end) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Data> pq = new PriorityQueue();
		
		pq.offer(new Data(start, 0)); 
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll(); 
			
			if(dist[cur.n] != cur.w) continue;
			
			for(Data next : adjList[cur.n]) {
				
				if(dist[next.n] <= cur.w + next.w) continue;
				
				dist[next.n] = cur.w + next.w;
				pq.offer(new Data(next.n, cur.w + next.w)); 
			}
		}
		
		return dist[end];
	}
}