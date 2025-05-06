import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N]; 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[2][N];
		
		for(int i=0; i<2; i++) {
			Arrays.fill(dp[i], 1); 
		}
		
		int answer = 1; 
		for(int i=1; i<N; i++) {
			int cur = arr[i];
			
			int increase = 0; 
			int decrease = 0; 
			for(int j=i; j>=0; j--) {
				if(cur > arr[j]) {
					increase = Math.max(dp[0][j], increase); 
				}
				
//				System.out.println(dp[0][j] + " " + dp[1][j]);
				if(cur < arr[j]) decrease = Math.max(decrease, Math.max(dp[0][j], dp[1][j])); 
			}
			
			dp[0][i] = increase + 1; 
			dp[1][i] = decrease + 1; 
			
			answer = Math.max(answer, Math.max(dp[0][i], dp[1][i]));
		}
		
//		System.out.println(Arrays.toString(dp[0]));
//		System.out.println(Arrays.toString(dp[1]));

		System.out.println(answer);
	}

}