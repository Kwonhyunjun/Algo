import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, arr[], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], -1);
			dp[i][i] = 1;
		}
		
		M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(solve(s-1, e-1)).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int solve(int s, int e) {
		
		if(dp[s][e] != -1) return dp[s][e];
		
		if(arr[s] != arr[e]) {
			dp[s][e] = 0;
			return dp[s][e];
		}
		
		if(Math.abs(s-e) == 1) {
			dp[s][e] = (arr[s] == arr[e]) ? 1 : 0;
			return dp[s][e];
		}else {			
			return dp[s][e] = solve(s+1, e-1);
		}
	}

}