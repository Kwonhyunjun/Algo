import java.io.*;
import java.util.*;
	
public class Main {
	
	static int N, w[][], dp[][], statusFullBit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		statusFullBit = (1 << N) -1;
		dp = new int[N][statusFullBit];
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(tsp(0, 1));

	}

	static int tsp(int x, int check) {
//		System.out.println(x + " " + check);
		if(check == statusFullBit) {			
			return (w[x][0] == 0) ? Integer.MAX_VALUE : w[x][0];
		}
		
		if(dp[x][check] != -1) return dp[x][check];
		
		dp[x][check] = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {		
			if(w[x][i] == 0) continue; // 경로가 없음
			if((check & (1 << i)) != 0) continue; // 방문체크
			
			int nxt = (check | (1 << i));
			
			int nextRoute = tsp(i, nxt);
			if(nextRoute != Integer.MAX_VALUE) dp[x][check] = Math.min(dp[x][check], nextRoute + w[x][i]);
		}
		
		return dp[x][check];
	}
}