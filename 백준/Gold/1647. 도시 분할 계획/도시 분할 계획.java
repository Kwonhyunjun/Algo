import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, parent[];
	
	static class Edge{
		int n1, n2, w; 
		
		public Edge(int n1, int n2, int w) {
			this.n1 = n1; 
			this.n2 = n2; 
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(n1, n2, w));
		}
		// Input End
		
		parent = new int[N+1]; 
		Arrays.fill(parent, -1);
		
		int maxEdge = -1;
		int totalEdge = 0;
				
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
//			System.out.printf("%d %d %d\n", cur.n1, cur.n2, cur.w);
			
			if(union(cur.n1, cur.n2)) {
//				System.out.println("union");
				totalEdge += cur.w;
				maxEdge = Math.max(maxEdge, cur.w);
			}
			
//			System.out.println(Arrays.toString(parent));
		}
		
		System.out.println(totalEdge - maxEdge);
		

	}
	
	static int find(int x) {
		if(parent[x] == -1) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX == parentY) {
			return false; 
		}
		
		parent[parentX] = parentY; 
		return true; 
	}

}