import java.io.*;
import java.util.*; 

public class Main {
	
	static int T, W, tree[]; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken()); // 최대 움직일 수 있는 
		
		tree = new int[T];
		
		for(int i=0; i<T; i++) {
			tree[i] = Integer.parseInt(br.readLine()); 
		}
		
		int[][][] dp = new int[T][W+1][2];
		
		for(int t=0; t<T; t++) {
			for(int w=0; w<=W; w++) {
				Arrays.fill(dp[t][w], 0);
			}
		}
		
		// 초기화
		dp[0][0][0] = (tree[0] == 1) ? 1 : 0;
		if(tree[0] == 2) {
			dp[0][1][1] = 1; 
		}
		
		for(int t=1; t<T; t++) {
			dp[t][0][0] = (tree[t] == 1) ? dp[t-1][0][0] + 1 : dp[t-1][0][0];
		}
		
		for(int t=1; t<T; t++) {
			for(int w=1; w<=W; w++) {
				
				for(int i=0; i<2; i++) {
					int cur = (tree[t] == i+1) ? 1 : 0; 
					
					dp[t][w][i] = Math.max(dp[t-1][w-1][(i+1) % 2], dp[t-1][w][i]) + cur;
					
				}
			}
		}
		
		int answer = 0; 
		for(int w=0; w<=W; w++) {
			for(int i=0; i<2; i++) {
				answer = Math.max(answer, dp[T-1][w][i]);
			}
		}
		
		System.out.println(answer);
	}

}