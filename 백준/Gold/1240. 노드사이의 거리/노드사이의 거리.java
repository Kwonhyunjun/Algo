import java.io.*;
import java.util.*;

public class Main {

	static int N, M, answer;
	static ArrayList<int[]>[] adjList; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new int[] {b, w});
			adjList[b].add(new int[] {a, w});
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			bfs(n1, n2, new boolean[N+1]);
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

	static void bfs(int n1, int n2, boolean[] v) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {n1, 0});
		v[n1] = true; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == n2) {
				answer = cur[1];
				return; 
			}
			
			for(int[] next : adjList[cur[0]]) {
				if(v[next[0]]) continue;
				
				v[next[0]] = true;
				q.offer(new int[] {next[0], cur[1]+next[1]});
			}
		}
	}
}