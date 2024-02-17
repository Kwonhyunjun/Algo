import java.io.*;
import java.util.*; 

public class Main {

	static int V, E, start, dist[]; 
	static ArrayList<int[]>[] adjList; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		adjList = new ArrayList[V+1]; 
		for(int i=1; i<V+1; i++) {
			adjList[i] = new ArrayList<>(); 
		}
		
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()); 
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new int[]{v, w}); 
		}
		
		dist[start] = 0; 
		dijkstra(start);  
//		System.out.println(Arrays.toString(dist));
		StringBuilder sb = new StringBuilder();
		for(int i=1 ; i<V+1; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			}else {
				sb.append(dist[i]).append("\n");
			}
			 
		}
		System.out.println(sb);
	}

	private static void dijkstra(int s) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		}); 
		
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll(); 
			int curP = cur[0];
			int curW = cur[1]; 
			
			if(dist[curP] == curW) {	
				for(int i = 0 ; i < adjList[curP].size(); i++) {
					// 만약 거리가 짧다면 갱신 
					int[] n = adjList[curP].get(i); 
					int np = n[0];
					int nw = n[1]; 
					
					if(dist[np] > curW + nw) {
						dist[np]= curW + nw; 
						pq.offer(new int[] {np, curW + nw}); 
					}
				}
			}
			
		}
		
	}

	
}