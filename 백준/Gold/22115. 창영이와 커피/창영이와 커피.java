import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coffee = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			coffee[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1];
		
		if(K == 0) {
			System.out.println(0);
			return; 
		}
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], 1001);
			dp[i][0] = 0; 
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=K; j>=0; j--) {
				if(j - coffee[i-1] >= 0) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j - coffee[i-1]]+1); 
				}else {
					dp[i][j] = dp[i-1][j]; 
				}
			}
		}
		
//		for(int i=0; i<=N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		int answer = (dp[N][K] == 1001) ? -1 : dp[N][K]; 
		
		System.out.println(answer);
		
	}

}