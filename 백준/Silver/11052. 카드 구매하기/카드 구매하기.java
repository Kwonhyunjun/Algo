import java.io.*;
import java.util.*;

public class Main {
	
	static int N, cards[], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		cards = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[0][0] = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=N; j++) {
				if(dp[i][j] == -1) continue;
				
				int cardCnt = i+1;
				int idx = j;
				int cnt = 0; 
				while(idx <= N) {
					dp[i+1][idx] = Math.max(dp[i+1][idx], dp[i][j] + (cards[i+1] * cnt)); 
					idx += cardCnt;
					cnt++; 
				}
			}
		}
		
		System.out.println(dp[N][N]);
		
		

	}

}