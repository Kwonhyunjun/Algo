import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[], answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Long[][] dp = new Long[N-1][21];
		
		for(int i=0; i<N-1; i++) {
			Arrays.fill(dp[i], 0L);
		}
		
		dp[0][arr[0]] = 1L;
		
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<21; j++) {
				
				if(j-arr[i+1] >= 0) dp[i+1][j-arr[i+1]] += dp[i][j];
				if(j+arr[i+1] <= 20) dp[i+1][j+arr[i+1]] += dp[i][j];
			}
		}
		
		System.out.println(dp[N-2][arr[N-1]]);
	}
}