import java.io.*;
import java.util.*;

public class Main {

	static int N, matrix[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N][2]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			matrix[i][0] = r;
			matrix[i][1] = c;
		}
		
		
		int[][] dp = new int[N][N];
		
		for(int i=1; i<N; i++) { // 구간 범위의 크기
			for(int j=0; i+j < N; j++) { // 구간 범위의 시작점
				
				dp[j][i+j] = Integer.MAX_VALUE;
				
				for(int k=j; k<i+j; k++) {
					dp[j][i+j] = Math.min(dp[j][i+j], dp[j][k] + dp[k+1][i+j] + matrix[j][0] * matrix[k][1] * matrix[i+j][1]);
				}
				
			}
			
		}
		
		System.out.println(dp[0][N-1]);

	}
}