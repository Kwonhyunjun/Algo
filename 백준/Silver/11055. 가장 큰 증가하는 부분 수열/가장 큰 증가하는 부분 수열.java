import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0; 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		
		int[][] dp = new int[N][max+1];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		
		dp[0][arr[0]] = arr[0];
		
		for(int i=1; i<N; i++) {
			int cur = arr[i];
			
			// 해당 원소부터 시작
			dp[i][cur] = Math.max(dp[i][cur], cur);

			
			for(int j=0; j<=max; j++) {
				if(dp[i-1][j] == Integer.MIN_VALUE) continue;
				
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				if(j < cur) {
					dp[i][cur] = Math.max(dp[i][cur], dp[i-1][j] + cur);
				}
			}
		}
		
		int answer = -1; 
		for(int i=0; i<=max; i++) {
			answer = Math.max(answer, dp[N-1][i]);
		}
		
		System.out.println(answer);
		

	}

}