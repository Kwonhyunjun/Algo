import java.io.*; 
import java.util.*; 

public class Main {

	static int N, M, X, dist[], back[];
	static ArrayList<Data>[] adjList; 
	
	static class Data implements Comparable<Data>{
		int num; 
		int weight;
		
		public Data(int num, int weight) {
			this.num = num;
			this.weight = weight;
		} 
		
		@Override
		public String toString() {
			return "[ " + num +" , " + weight + " ]"; 
		}

		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		X = Integer.parseInt(st.nextToken()); 
		
		adjList = new ArrayList[N+1]; 
		back = new int[N+1];
		int[] total = new int[N+1];
//		Arrays.fill(dist, Integer.MAX_VALUE); 
		
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList<>(); 
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[to].add(new Data(from, weight)); 
		}
		
//		Arrays.fill(dist, Integer.MAX_VALUE); 
//		dist[X] = 0; 
//		dijkstra(X); 
//		back = dist;
//		System.out.println(Arrays.toString(back));
//		
//		int ans = 0; 
//		for(int i=1; i<N+1; i++) {
//			if(i == X) continue; 
//			dijkstra(i);		
//			System.out.println(i);
//			System.out.println(Arrays.toString(dist)); 
//			
//			ans = Math.max(ans, dist[X] + back[i]);
//			total[i] = dist[X] + back[i]; 
//		}
//		
//		System.out.println(Arrays.toString(total));
		
		int ans = 0; 
		for(int st1 = 1; st1 <=N; st1++) {
			ans = Math.max(ans, solve(st1, X) + solve(X, st1)); 
		}
		
		System.out.println(ans); 
	}

	private static int solve(int start, int end) {
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE); 
		
		PriorityQueue<Data> pq = new PriorityQueue<>(); 
		
		// 시작 정점 넣기
		dist[start] = 0; 
		pq.offer(new Data(start, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll(); 
			
			if(dist[cur.num] != cur.weight) continue; 
			
			for(Data next : adjList[cur.num]) {
				
				if(dist[next.num] <= dist[cur.num] + next.weight) continue;
				
				dist[next.num] = dist[cur.num] + next.weight;
				pq.offer(new Data(next.num, dist[cur.num] + next.weight)); 
				
			}
			
		}
		return dist[end]; 
	}

}