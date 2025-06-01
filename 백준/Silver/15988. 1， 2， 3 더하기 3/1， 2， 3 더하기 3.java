import java.io.*;
import java.util.*;

public class Main {

	static int T;
	static long dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		T = Integer.parseInt(br.readLine());
		
		dp = new long[1000001];
		Arrays.fill(dp, -1);
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(solve(n)).append("\n");
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(sb);

	}
	
	static long mod = 1000000009;
	static long solve(int n) {
		if(dp[n] != -1) {
			return dp[n];
		}
		
		return dp[n] = (((solve(n-1) % mod + solve(n-2) % mod) % mod + solve(n-3) % mod) % mod);
	}

}