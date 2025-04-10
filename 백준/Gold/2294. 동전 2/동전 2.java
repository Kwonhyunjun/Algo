import java.io.*;
import java.util.*;

public class Main {

	static int N, K, coins[], dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coins = new int[N];
		
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for(int i=0; i<K; i++) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			
			for(int coin : coins) {
				if(i+coin > K) continue;
				
				dp[i+coin] = Math.min(dp[i]+1, dp[i+coin]);
			}
		}
		
		System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);

	}

}