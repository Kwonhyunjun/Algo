import java.io.*;
import java.util.*;

public class Main {
	
	static int N, wines[]; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		wines = new int[N];
		
		for(int i=0; i<N; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		
		dp[0][0] = 0;
		dp[0][1] = wines[0]; 
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<3; j++) {
				int cur = dp[i][j];
				if(cur == Integer.MAX_VALUE) continue;
				
				// 마신다
				if(j+1 < 3) dp[i+1][j+1] = Math.max(cur + wines[i+1], dp[i+1][j+1]);
				
				// 안마신다
				dp[i+1][0] = Math.max(dp[i+1][0], cur);
				
			}
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		int answer = -1; 
		for(int cur : dp[N-1]) {
			answer = Math.max(answer, cur);
		}
		
		System.out.println(answer);
	}

}