import java.io.*;
import java.util.*;

public class Main {

	static int N, M, apps[], cost[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 앱의 개수 
		M = Integer.parseInt(st.nextToken()); // 확보해야할 메모리 용량
		
		apps = new int[N+1];
		cost = new int[N+1];
		
		int costSum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			apps[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			costSum += cost[i];
		}
		
		int[][] dp = new int[N+1][costSum+1];
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		
		dp[0][0] = 0;
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<=costSum; j++) {
				if(dp[i][j] == Integer.MIN_VALUE) continue;
				
				// 추가X
				dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
				
				// 추가
				int nextIdx = j+cost[i+1]; 
				dp[i+1][j+cost[i+1]] = Math.max(dp[i+1][j+cost[i+1]], dp[i][j] + apps[i+1]);
			}
		}
		
//		for(int i=0; i<=N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		for(int i=0; i<=costSum; i++) {
			if(dp[N][i] >= M) {
				System.out.println(i);
				break;
			}
		}

	}

}