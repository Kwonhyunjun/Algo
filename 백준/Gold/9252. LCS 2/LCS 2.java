import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int len1 = str1.length;
		int len2 = str2.length;
		
		int[][] dp = new int[len1][len2];
//		String[][] maxString = new String[len1][len2];
		
		if(str1[0] == str2[0]) {
			dp[0][0] = 1;
//			maxString[0][0] = String.valueOf(str1[0]);
		}
		
		for(int i=1; i<len1; i++) {
			if(dp[i-1][0] == 1) {
				dp[i][0] = 1; 
//				maxString[i][0] = maxString[i-1][0]; 
			}else if(str1[i] == str2[0]) {
				dp[i][0] = 1;
//				maxString[i][0] = String.valueOf(str1[i]);
			}
		}
		

		for(int i=1; i<len2; i++) {
			if(dp[0][i-1] == 1) {
				dp[0][i] = 1; 
//				maxString[0][i] = maxString[0][i-1]; 
			}else if(str1[0] == str2[i]) {
				dp[0][i] = 1;
//				maxString[0][i] = String.valueOf(str2[i]);
			}
		}
		
		for(int i=1; i<len1; i++) {
			for(int j=1; j<len2; j++) {
				if(str1[i] == str2[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
//					maxString[i][j] = (maxString[i-1][j-1] == null) ? String.valueOf(str1[i]) : maxString[i-1][j-1] + str1[i];
				}else {
					if(dp[i-1][j] > dp[i][j-1]) {
						dp[i][j] = dp[i-1][j];
//						maxString[i][j] = maxString[i-1][j];
					}else {
						dp[i][j] = dp[i][j-1];
//						maxString[i][j] = maxString[i][j-1];
					}
				}
			}
		}
		

		System.out.println(dp[len1-1][len2-1]);
//		if(dp[len1-1][len2-1] != 0) System.out.println(maxString[len1-1][len2-1]);
		if(dp[len1-1][len2-1] != 0) {
			StringBuilder sb = new StringBuilder();
			int r = len1-1;
			int c = len2-1;
			
			while(true) {
				if(r == 0 || c == 0) {
					
					if(dp[r][c] == 1) {
						sb.append((r==0) ? str1[0] : str2[0]);
					}
					break;
				}
				
				if(str1[r] == str2[c]) {
					sb.append(str1[r]);
					r--;
					c--;
				}else {
					if(dp[r][c] == dp[r-1][c]) {
						r--;
					}else {
						c--;
					}
				}
			}
			
			sb.reverse();
			System.out.println(sb);
		}
	}

}