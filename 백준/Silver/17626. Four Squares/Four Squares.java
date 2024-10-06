import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, answer, dp[]; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		dp = new int[50001];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0; 
		
		for(int i=1; i<=N; i++) {
			int sqrt = (int) Math.sqrt(i);
			
			for(int j=1; j<=sqrt; j++) {
				int square = j * j; 
				
				dp[i] = Math.min(dp[i], dp[i-square] + 1); 
			}
		}
		
		System.out.println(dp[N]);
		

	}

}