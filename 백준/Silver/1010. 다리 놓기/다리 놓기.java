import java.io.*;
import java.util.*;

public class Main {
	
	static int dp[][] = new int[30][30];;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(solve(M, N));
			
		}
		
	}
	
	static int solve(int n, int r) {
		
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = solve(n-1, r-1) + solve(n-1, r);
	}

}