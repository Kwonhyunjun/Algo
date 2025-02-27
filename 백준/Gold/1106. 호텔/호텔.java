import java.io.*;
import java.util.*;

public class Main {

	static int C, N;
	static Data[] map;
	
	static class Data implements Comparable<Data>{
		int cost, guest;
		double value;
		
		public Data(int cost, int guest) {
			this.cost = cost;
			this.guest = guest;
			value = (double) guest / cost;
		}
		
		@Override
		public int compareTo(Data o) {
			int res = Double.compare(this.value, o.value);
			
			if(res == 0) {
				return -(this.guest - o.guest);
			}
			
			return -res;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new Data[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int cost = Integer.parseInt(st.nextToken());
			int guest = Integer.parseInt(st.nextToken());
			
			map[i] = new Data(cost, guest);
		}
		
	
		int[][] dp = new int[N+1][C+1];
		for(int i=0; i<=N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][0] = 0; 
		}
		
		for(int i=1; i<=N; i++) {
			
			int cost = map[i].cost;
			int guest = map[i].guest;
			
			for(int j=0; j<=C; j++) {
				if(dp[i-1][j] == Integer.MAX_VALUE) continue;
				
				int cnt = 0;
				int next = j;
				while(next <= C) {
					int curCost = dp[i-1][j] + (cost * cnt); 
					dp[i][next] = Math.min(dp[i][next], curCost);
					cnt++;
					next += guest;
				}
				
				int beyondCost = dp[i-1][j] + (cost * cnt);
				if(dp[i][C] > beyondCost) {
					dp[i][C] = beyondCost;
				}
			}
		}
		
		System.out.println(dp[N][C]);
		
		
	}

}