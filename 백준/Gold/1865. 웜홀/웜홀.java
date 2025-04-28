import java.io.*;
import java.util.*;

public class Main {

	static int N, M, W, dist[];
	static class Edge{
		int s, e, w;
		
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	
	static List<Edge> edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 노드의 개수
			M = Integer.parseInt(st.nextToken()); // 도로의 개수
			W = Integer.parseInt(st.nextToken()); // 웜홀의 개수
			
			edgeList = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				edgeList.add(new Edge(s, e, w));
				edgeList.add(new Edge(e, s, w));
			}
			
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				edgeList.add(new Edge(s, e, (w * -1)));
			}
			
			boolean flag = false;
			for(int i=1; i<=N; i++) {
				dist = new int[N+1]; 
				Arrays.fill(dist , Integer.MAX_VALUE);
				if(checkMinusCycle(i)) {
					flag = true;
					break;
				}
			}
			sb.append((flag) ? "YES" : "NO").append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static boolean checkMinusCycle(int start) {
		dist[start] = 0;
		boolean isUpdated = false;
		
		for(int i=0; i<N-1; i++) {
			isUpdated = false;
			
			for(Edge edge : edgeList) {
				int s = edge.s; 
				int e = edge.e;
				int w = edge.w; 
				
				if(dist[s] == Integer.MAX_VALUE) continue;
				if(dist[e] <= dist[s] + w) continue;
				
				dist[e] = dist[s] + w;
				isUpdated = true;
			}
			
			if(!isUpdated) break;
		}
		
		if(isUpdated) {
			for(Edge edge : edgeList) {
				int s = edge.s; 
				int e = edge.e;
				int w = edge.w; 
				
				if(dist[s] == Integer.MAX_VALUE) continue;
				if(dist[e] <= dist[s] + w) continue;
				
				return true;
			}			
		}
		
		
		return false;
		
	}

}