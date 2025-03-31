import java.io.*;
import java.util.*;

public class Main {

	static int T, N, arr[];
	static boolean[] v;
	static List<Integer>[] adjList; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			adjList = new List[N+1];
			for(int i=0; i<=N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=1; i<=N; i++) {
				adjList[i].add(arr[i]);
			}
			
			v = new boolean[N+1];
			
			int cnt = 0;
			for(int i=1; i<=N; i++) {
				if(v[i]) continue; 
				
				cnt++; 
				bfs(i);
			}
			
			System.out.println(cnt);
		}
	}
	
	static void bfs(int s) {
		Queue<Integer> q = new ArrayDeque<>(); 
		
		v[s] = true;
		q.offer(s);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int nxt : adjList[cur]) {
				if(v[nxt]) continue; 
				
				v[nxt] = true;
				q.offer(nxt);
			}
		}
	}

}