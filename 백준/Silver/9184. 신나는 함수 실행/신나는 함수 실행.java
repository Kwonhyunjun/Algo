import java.io.*;
import java.util.*;
	
public class Main {
	
	static int[][][] dp = new int[101][101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				Arrays.fill(dp[i][j], -1); 
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) break;
			
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
		}

	}

	static int w(int a, int b, int c) {
		int idxA = a + 50;
		int idxB = b + 50;
		int idxC = c + 50;
		
		if(dp[idxA][idxB][idxC] != -1) {
			return dp[idxA][idxB][idxC];
		}else if (a <= 0 || b <= 0 || c <= 0) {
			return dp[idxA][idxB][idxC] = 1; 
		}else if (a > 20 || b > 20 || c > 20) {
			return dp[idxA][idxB][idxC] = w(20, 20, 20); 
		}else if(a < b && b < c) {
			return dp[idxA][idxB][idxC] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}else {
			return dp[idxA][idxB][idxC] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1); 
		}
	}
}