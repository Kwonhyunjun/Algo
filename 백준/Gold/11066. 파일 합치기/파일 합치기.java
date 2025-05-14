import java.io.*;
import java.util.*;

public class Main {
	
	static int T, K, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			arr = new int[K];
			for(int i=0; i<K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 누적합
			int[] prefix = new int[K+1];
			for(int i=1; i<=K; i++) {
				prefix[i] = prefix[i-1] + arr[i-1];
			}
			
			
			int[][] dp = new int[K][K];
			
			// 초기화
			for(int i=0; i<K; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
				dp[i][i] = 0;
			}
			
			for(int g=1; g<K; g++) { // Gap
//				System.out.printf("gap : %d\n", g);
				
				for(int s=0; s<K-g; s++) {
					int e = s + g; 
					
//					System.out.printf("s(%d)~e(%d)\n", s, e);
					
					if(g == 1) {
						dp[s][e] = arr[s] + arr[e];
					}else {
						int res = Integer.MAX_VALUE;
						
						for(int l = s ; l < e; l++) {
//							System.out.printf("prev -> arr[s](%d) + (prefix[e+1](%d) - prefix[s+1](%d))(%d) + dp[s+1][e](%d) = %d\n", arr[s], prefix[e+1], prefix[s+1], (prefix[e+1] - prefix[s+1]), dp[s+1][e], arr[s] + (prefix[e+1] - prefix[s+1]) + dp[s+1][e]);
//							System.out.printf("next -> dp[s][e-1](%d)+ (prefix[e](%d) - prefix[s](%d))(%d) + arr[e](%d) = %d \n", dp[s][e-1], prefix[e], prefix[s], (prefix[e] - prefix[s]), arr[e],(dp[s][e-1] + (prefix[e] - prefix[s]) + arr[e]));
//							res = Math.min(res, arr[s] + (prefix[e+1] - prefix[s+1]) + dp[s+1][e]); 
//							res = Math.min(res, dp[s][e-1] + (prefix[e] - prefix[s]) + arr[e]); 
							
							res = Math.min(res , (
										dp[s][l] + dp[l+1][e] + 
										(prefix[l+1] - prefix[s]) 
										+ prefix[e+1] - prefix[l+1]
									));
						}
						
						
						dp[s][e] = res;
					}
					
//					System.out.println("dp[s][e] : " + dp[s][e]);
				}
				
				// print()
//				for(int i=0; i<K; i++) {
//					System.out.println(Arrays.toString(dp[i]));
//				}
			}
			
			System.out.println(dp[0][K-1]);
			
		}
	}

}