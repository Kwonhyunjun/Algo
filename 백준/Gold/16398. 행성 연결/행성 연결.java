import java.io.*;
import java.util.*;

public class Main {
	
	static int N, parent[];
	static class Edge{
		
		int node1, node2, weight;
		
		public Edge(int node1, int node2, int weight) {
			this.node1 = node1;
			this.node2 = node2; 
			this.weight = weight;
		}
	}
	
	static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(i >= j) continue;
//				System.out.println(num);
				pq.offer(new Edge(i, j, num));
			}
		}
		
		parent = new int[N];
		Arrays.fill(parent, -1);
		
		int cnt = 0;
		long totalWeight = 0;
		while(cnt < N-1) {
			Edge cur = pq.poll();
			
			if(union(cur.node1, cur.node2)) {
//				System.out.println(cur.node1 + " " + cur.node2 + " " + cur.weight);
				totalWeight += cur.weight;
				cnt++;
			}
		}
		
		System.out.println(totalWeight);
		
	}

	static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX == parentY) return false;
		
		parent[parentX] = parentY;
		
		return true;
	}
	
	static int find(int x) {
		if(parent[x] == -1) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
}