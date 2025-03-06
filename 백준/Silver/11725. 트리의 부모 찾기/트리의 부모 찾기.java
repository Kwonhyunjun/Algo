import java.io.*;
import java.util.*; 

public class Main {

	static int N, parent[];
	static List<Integer>[] adjList;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjList = new List[N+1];
		parent = new int[N+1];
		
		Arrays.fill(parent, -2); 
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		parent[1] = -1;
		dfs(1, -1);
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++) {
//			System.out.println(parent[i]);
			sb.append(parent[i]).append("\n");
		}
			
		System.out.println(sb);

	}
	
	static void dfs(int cur, int prevNode) {
		
//		System.out.println(cur);
		parent[cur] = prevNode;
		
		for(int nxt : adjList[cur]) {
			if(parent[nxt] != -2) continue;
			 
			dfs(nxt, cur);
			
		}
	}

}