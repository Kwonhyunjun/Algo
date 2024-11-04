import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, T, study[][], answer; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		T = Integer.parseInt(st.nextToken()); 
		
		study = new int[N][2]; 
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int time = Integer.parseInt(st.nextToken()); 
			int score = Integer.parseInt(st.nextToken());
			
			study[i][0] = time;
			study[i][1] = score; 
		}
		
		int[][] dp = new int[N+1][T+1]; 
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		
		dp[0][0] = 0; 
		
		for(int i=1; i<=N; i++) {
			int[] cur = study[i-1];
			
			for(int j=0; j<=T; j++) {
				if(dp[i-1][j] == Integer.MIN_VALUE) continue; 
				
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]); 
				
				if(j + cur[0] > T) continue; 
				dp[i][j+cur[0]] = Math.max(dp[i][cur[0]], dp[i-1][j] + cur[1]); 
			}
			
		}
		
//		for(int i=0; i<=N; i++) {
//			System.out.println(dp[i][0] + " " + dp[i][50] + " "+ dp[i][100] + " "+ dp[i][150] + " "+ dp[i][200] + " "+ dp[i][250] + " "+ dp[i][300] + " "+ dp[i][310]);
//		}
		
		int answer = 0;
		
		for(int i=1; i<=T; i++) {
			answer = Math.max(answer, dp[N][i]);
		}
		System.out.println(answer);
		
	}
	
}