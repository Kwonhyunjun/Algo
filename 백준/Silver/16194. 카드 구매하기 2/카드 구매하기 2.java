import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] price = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=1; j<=N; j++) {
				int nxt = i+j;
				if(nxt > N) continue;
				
				dp[nxt] = Math.min(dp[nxt], dp[i] + price[j]);
			}
		}
		
		System.out.println(dp[N]);

	}

}