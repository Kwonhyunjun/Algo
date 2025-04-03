import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, K, dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		
		int answer = solve(0, 0);
		
		System.out.println(answer);

	}
	
	static int solve(int num, int cnt) {
		if(cnt == K) {
			if(num == N) return 1;
			return 0;
		}
		
		if(dp[num][cnt] != 0) return dp[num][cnt];
		
		int res = 0; 
		
		for(int i=0; i<=N; i++) {
			if(num + i > N) continue;
			res = (res + solve(num + i, cnt+1)) % 1_000_000_000;
		}
		
		dp[num][cnt] = res % 1_000_000_000;
		
		return dp[num][cnt];
	}

}