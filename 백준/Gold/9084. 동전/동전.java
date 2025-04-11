import java.io.*;
import java.util.*;

public class Main {
	
	static int T, N, coins[], M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			coins = new int[N];			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());
			
			
			int[][] dp = new int[N][M+1];
			
			for(int i=0; i<M+1; i=i+coins[0]) {
				dp[0][i] = 1; 
			}
			
//			System.out.println(Arrays.toString(dp[0]));
			
			for(int i=1; i<N; i++) {
				int curCoin = coins[i];
				
				for(int j=0; j<M+1; j++) {
					
					dp[i][j] += dp[i-1][j];
					
					if(j-curCoin >= 0) {
						dp[i][j] += dp[i][j-curCoin];
					}
				}
			}
			
			sb.append(dp[N-1][M]).append("\n");
		}
		
		System.out.println(sb);
	}

}