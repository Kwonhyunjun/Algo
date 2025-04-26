import java.io.*; 
import java.util.*;
	
public class Main {

	static int N, M, K, X, dist[];
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adjList = new List[N+1];
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
//			adjList[b].add(a);
		}
		
		dist = new int[N+1]; 
		Arrays.fill(dist, Integer.MAX_VALUE);
		djikstra(X);
		
//		System.out.println(Arrays.toString(dist));
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) {
			if(dist[i] == K) sb.append(i).append("\n");
		}
		System.out.println((sb.length() == 0) ? -1 : sb);
	}
	
	static void djikstra(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {start, 0});
		dist[X] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int nxt : adjList[cur[0]]) {
				if(dist[nxt] < cur[1]+1) continue;
				
				q.offer(new int[] {nxt, cur[1]+1});
				dist[nxt]= cur[1]+1;
				
			}
		}
		
	}

}