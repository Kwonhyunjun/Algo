import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		
		int N = arr1.length; 
		int M = arr2.length;
		
		int[][] dp = new int[N][M];
		
		if(arr1[0] == arr2[0]) dp[0][0] = 1; 
		
		for(int i=1; i<N; i++) {
			if(arr1[i] == arr2[0]) {
				dp[i][0] = 1;
			}else {
				dp[i][0] = (dp[i-1][0] == 1)? 1 : 0; 
			}
		}
		
		for(int j=1; j<M; j++) {
			if(arr1[0] == arr2[j]) {
				dp[0][j] = 1; 
			}else {
				dp[0][j] = (dp[0][j-1] == 1)? 1 : 0; 
			}
		}
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				if(arr1[i] == arr2[j]) {
					dp[i][j] = dp[i-1][j-1] + 1; 
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
				}
			}
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		System.out.println(dp[N-1][M-1]);
		
		
	}

}