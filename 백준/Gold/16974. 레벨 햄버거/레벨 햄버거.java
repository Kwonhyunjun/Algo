import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt;
	static Long X;
	static long[] total, pat; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		
		total = new long[N+1];
		pat = new long[N+1];
		total[0] = 1;
		pat[0] = 1;
		
		for(int i=1; i<=N; i++) {
			total[i] = 1 + total[i-1] + 1 + total[i-1] + 1;
			pat[i] = pat[i-1] + 1 + pat[i-1]; 
		}
		
		long ans = solve(N, X); 
		
		System.out.println(ans);
	}
	
	static long solve(int n, long x) {
		if(n == 0) {
    		// 하나도 안 먹음
    		if(x == 0) {
    			return 0;
    		} 
    		// 한 장 먹음
    		else if(x == 1) {
    			return 1;
    		}
    	}
		
		if(x == 1) {
    		return 0;
    	} 
    	else if(x <= 1 + total[n-1]) {
    		return solve(n-1, x-1);
    	} 
    	else if(x == 1 + total[n-1] + 1) {
    		return pat[n-1] + 1;
    	} 
    	else if(x <= 1 + total[n-1] + 1 + total[n-1]) {
    		return pat[n-1] + 1 + solve(n-1, x - (1 + total[n-1] + 1));
    	} 
    	else {
    		return pat[n-1] + 1 + pat[n-1];
    	}
	}

}