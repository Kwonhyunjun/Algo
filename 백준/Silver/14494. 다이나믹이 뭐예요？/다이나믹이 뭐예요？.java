import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][M];
		
		int[] dr = new int[] {-1, -1, 0};
		int[] dc = new int[] {-1, 0, -1}; 
		
		dp[0][0] = 1; 
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				for(int d=0; d<3; d++) {
					int prevR = r + dr[d];
					int prevC = c + dc[d];
					
					if(prevR < 0 || prevC < 0 || prevR >= N || prevC >= M) continue;
					dp[r][c] = (dp[r][c] + dp[prevR][prevC]) % 1000000007; 
				}
			}
		}

		
		System.out.println(dp[N-1][M-1]); 
	}

}