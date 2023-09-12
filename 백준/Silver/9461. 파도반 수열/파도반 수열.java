import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static long dp[]; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for(int t=0; t<TC; t++) {
			int N = Integer.parseInt(br.readLine());
			
			dp = new long[N+4];
			
			// 초기값 세팅
			dp[1] = 1; 
			dp[2] = 1; 
			dp[3] = 1; 
			
			if(N <= 3) {
				
				System.out.println(dp[N]);
			}else {
				for(int i=4; i<=N ; i++) {
					dp[i] = dp[i-2] + dp[i-3];
				}
				
				System.out.println(dp[N]);				
			}
			
		}
	}

}