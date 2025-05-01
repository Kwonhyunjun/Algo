import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, parents[];
	static class Edge {
		int n1, n2, weight;
		
		public Edge(int n1, int n2, int weight) {
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
		}
	}
	
	static PriorityQueue<Edge> edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 집의 수
			M = Integer.parseInt(st.nextToken()); // 길의 수
			
			if(N == 0 && M == 0) break;
			
			edges = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
			
			int totalCost = 0;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				totalCost += weight; 
				edges.offer(new Edge(n1, n2, weight));
			}
			
			parents = new int[N+1];
			Arrays.fill(parents, -1);
			
			int answer = 0;
			int cnt = 0;
			while(!edges.isEmpty()) {
				Edge cur = edges.poll();
				
//				System.out.println(cur.n1 + " " + cur.n2 + " " + cur.weight);
				
				if(!union(cur.n1, cur.n2)) {
					continue;
				}else {
					answer += cur.weight;
					cnt++; 
				}
				
				if(cnt == N-1) {
					break;
				}
			}
			
			sb.append(totalCost - answer).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX == parentY) {
			return false;
		}
		
		parents[parentX] = parentY;
		
		return true;
	}
	
	static int find(int n) {
		if(parents[n] == -1) {
			return n;
		}
		
		return parents[n] = find(parents[n]); 
	}

}