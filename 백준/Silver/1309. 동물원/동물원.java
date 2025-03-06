import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int len = N;
		
		int[][] dp = new int[len][3];
		
		Arrays.fill(dp[0], 1);
		
		for(int i=1; i<len; i++) {
			for(int j=0; j<3; j++) {
				int left = (j == 0) ? 0 : dp[i-1][0];
				int right = (j == 1) ? 0 : dp[i-1][1];
				
				dp[i][j] += (left + right + dp[i-1][2]) % 9901; 
			}
		}
		
		
		int answer = 0; 
		
		for(int i=0; i<3; i++) {
			answer += dp[len-1][i];  
		}
		
		System.out.println(answer % 9901); 
		

	}

}