import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M]; 
		int[][][] dp = new int[N][M][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0 ;j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				Arrays.fill(dp[i][j], Integer.MAX_VALUE); 
			}
		}
		
		// 초기화
		for(int i=0; i<M; i++) {
			
			// 왼쪽
			if(i-1 >= 0) {
				dp[1][i][0] = map[0][i-1] + map[1][i]; 
			}
			
			// 위쪽
			dp[1][i][1] = map[0][i] + map[1][i]; 
			
			// 오른쪽
			if(i+1 < M) {
				dp[1][i][2] = map[0][i+1] + map[1][i]; 
			}
		}
		
		
		for(int i=2; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				// 왼쪽
				if(j-1 >= 0) {
					dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + map[i][j];  
				}
				
				// 위쪽
				dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j]; 
				
				// 오른쪽
				if(j+1 < M) {
					dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + map[i][j]; 
				}
			}
		}
		
		
		int answer = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<3; j++) {
				answer = Math.min(dp[N-1][i][j], answer);
			}
		}
		
		System.out.println(answer);

	}

}