import java.io.*;
import java.util.*;

public class Main {

	static int N, dp[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][10];
		
		Arrays.fill(dp[1], 1);
		
		int answer = 0;
		for(int i=0; i<10; i++) {
			answer += solve(i, N);
		}
		
//		for(int i=0; i<=N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(answer % 10007);
	}
	
	static int solve(int start, int digit) {
		if(dp[digit][start] != 0) return dp[digit][start];
		
		int res = 0;
		for(int i=start; i<10; i++) {
			res += solve(i, digit-1);
		}
		
		dp[digit][start] = res % 10007; 
		
		return dp[digit][start];
	}

}