import java.io.*;
import java.util.*;

public class Main {

	static int N, M, dist[];
	static ArrayList<int[]>[] adjList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new int[] {b, c});
			adjList[b].add(new int[] {a, c});
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		djikstra();
		
		System.out.println(dist[N]);
	}
	
	static void djikstra() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		q.offer(new int[] {1, 0});
		dist[1] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[1] > dist[cur[0]]) continue;
			
			for(int[] nxt : adjList[cur[0]]) {
				int nextNode = nxt[0];
				int weight = nxt[1];
				
				
				if(dist[nextNode] > cur[1] + weight) {
					q.offer(new int[] {nextNode, cur[1] + weight});
					dist[nextNode] = cur[1] + weight; 
				}
			}
		}
	}

}