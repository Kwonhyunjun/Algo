import java.io.*;
import java.util.*;

public class Main {
	
	static int N, farNode, diameter;
	static List<int[]>[] adjList; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		
		adjList = new List[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			boolean isNode = true;
			
			while(true) {
				int node = Integer.parseInt(st.nextToken());				
				if(node == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				
				adjList[n].add(new int[] {node, weight});
			}			
		}
		
		bfs(1);

		diameter = Integer.MIN_VALUE;
		bfs(farNode);
		
		System.out.println(diameter); 
	}
	
	static void bfs(int start) {
		boolean[] v = new boolean[N+1]; 
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {start, 0});
		v[start] = true;
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(diameter < cur[1]) {
				farNode = cur[0];
				diameter = cur[1];
			}
			
			for(int[] nxt : adjList[cur[0]]) {
				int nn = nxt[0];
				int nw = nxt[1];
				
				if(v[nn]) continue;
				
				q.offer(new int[] {nn, cur[1] + nw});
				v[nn] = true;
			}
		}
	}

}