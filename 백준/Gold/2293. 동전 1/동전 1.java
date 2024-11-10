import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N]; 
		
		for(int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine()); 
		}
		
		
		int[] dp = new int[K+1]; 
		
		dp[0] = 1;
		
		for(int coin : coins) {
			
			for(int i=1; i<=K; i++) {
				if(i - coin < 0) continue; 
				dp[i] += dp[i-coin]; 
			}
		}
		
		System.out.println(dp[K]); 

	}

}