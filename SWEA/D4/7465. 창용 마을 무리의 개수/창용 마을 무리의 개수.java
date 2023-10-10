import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static int N, M, ans;
	static List<Integer>[] adj; 
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			v = new boolean[N+1]; 
			adj = new List[N+1];
			ans = 0; 
			for(int i=0; i<N+1; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adj[from].add(to);
				adj[to].add(from);
			}
			
			for(int i=1; i<N+1; i++) {
				if(v[i]) continue; 
				bfs(i);
				ans++; 
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static void bfs(int s) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(s); 
		v[s] = true; 
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			int size = adj[cur].size(); 
			for(int i=0; i<size; i++) {
				int next = adj[cur].get(i);
				if(v[next]) continue;
				q.offer(next);
				v[next] = true;
			}
		}
		
	}
}