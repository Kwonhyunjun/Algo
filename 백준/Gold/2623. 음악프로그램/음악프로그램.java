import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, indgree[], cnt;
	static boolean[] v;
	static List<Integer>[] adjList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indgree = new int[N+1];
		v = new boolean[N+1];
		adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int k=1; k<n; k++) {
				int cur = Integer.parseInt(st.nextToken());
				adjList[prev].add(cur);
				indgree[cur]++;
				prev = cur;
			}
		}

		solve();
		System.out.println((cnt == N) ? sb : "0");
		
	}
	
	static void solve() {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			if(indgree[i] == 0) {
				q.offer(i);
				v[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			cnt++;
			sb.append(cur).append("\n");
			
			for(int nxt : adjList[cur]) {
				if(v[nxt]) continue;
				indgree[nxt]--;
				if(indgree[nxt] == 0) {
					q.offer(nxt);
					v[nxt] = true;
				}
			}
		}
	}

}