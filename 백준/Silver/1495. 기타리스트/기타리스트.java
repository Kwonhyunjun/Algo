import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, S, vol[], answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		vol = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			vol[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[M+1][N+1];
		dp[S][0] = true;
		
		for(int c=0; c<N; c++) {
			for(int r=0; r<=M; r++) {
//				System.out.println(c + " " + r);
				if(!dp[r][c]) continue;
				
				if(r+vol[c] <= M) dp[r+vol[c]][c+1] = true;
				if(r-vol[c] >= 0) dp[r-vol[c]][c+1] = true;
			}
		}
		
		answer = -1;
		for(int i=0; i<=M; i++) {
			if(dp[i][N]) {
				answer = Math.max(answer, i);
			}
		}
		
		System.out.println(answer);
		
	}

}