import java.io.*;
import java.util.*;

public class Main {
	
	static int N, times[], indgree[], dp[];
	static boolean v[];
	static ArrayList<Integer>[] adjList; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		times = new int[N+1];
		indgree = new int[N+1]; 
		adjList = new ArrayList[N+1];
		v = new boolean[N+1];
		dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			times[i] = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(st.nextToken());
			indgree[i] =n;
			for(int j=0; j<n; j++) {
				adjList[Integer.parseInt(st.nextToken())].add(i);
			}
		}
		
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			dp[i] = times[i];
			
			if(indgree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : adjList[now]) {
				indgree[next]--;
				
				dp[next] = Math.max(dp[next], dp[now] + times[next]);
				
				if(indgree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
	}

}