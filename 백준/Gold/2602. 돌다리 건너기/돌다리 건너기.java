import java.io.*;
import java.util.*;

public class Main {
	
	static int answer, len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		
		char[][] bridge = new char[2][];
		bridge[0] = br.readLine().toCharArray();
		bridge[1] = br.readLine().toCharArray();
		
		len = bridge[0].length;
		
		int[][][] dp = new int[str.length][2][len];
		
		// 초기화
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<len; j++) {
				if(bridge[i][j] == str[0]) {
					dp[0][i][j] = 1; 
				}
			}
		}
		
		
		for(int i=1; i<str.length; i++) {
			char cur = str[i];
			for(int j=0; j<2; j++) {
				int opp = (j==0) ? 1 : 0; 
				for(int k=i; k<len; k++) {
					if(bridge[j][k] != cur) continue;
					int prev = 0;
					for(int l=0; l<k; l++) {
						if(str[i-1] == bridge[opp][l])
							prev += dp[i-1][opp][l];
					}
					dp[i][j][k] = prev;
				}
			}
		}
		
		int answer = 0; 
		for(int i=0; i<2; i++) {
			for(int j=0; j<len; j++) {
				answer += dp[str.length-1][i][j];
			}
		}
		
		System.out.println(answer);
		
	}

}