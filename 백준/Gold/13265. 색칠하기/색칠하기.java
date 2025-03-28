import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, color[];
	static List<Integer>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			color = new int[N+1];
			
			adjList = new List[N+1];
			for(int i=1; i<=N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adjList[a].add(b);
				adjList[b].add(a);
			}
			
			color = new int[N+1];
			
			boolean flag = true;
			for(int i=1; i<=N; i++) {
				if(color[i] != 0) continue;
				
				if(!dfs(i, 1)) {
					flag = false;
					break;
				}
			}
			
			sb.append((flag) ? "possible" : "impossible").append("\n");
			
		}

		System.out.println(sb);
	}
	
	static boolean dfs(int node, int c) {
		
		color[node] = c;
		
		for(int nxt : adjList[node]) {
			if(color[nxt] == c) return false;
			if(color[nxt] != 0) continue;
			
			dfs(nxt, (c==1) ? 2 : 1);
		}
		
		
		return true;
	}

}