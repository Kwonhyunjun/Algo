import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[2][N];
		Arrays.fill(dp[0], 1);
		Arrays.fill(dp[1], -1);
		
		for(int i=1; i<N; i++) {
			int cnt = 0;
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j]) {
					if(cnt < dp[0][j]+1) {
						cnt = dp[0][j] + 1;
						dp[0][i] = cnt;
						dp[1][i] = j;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int maxLen = 0;
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(maxLen < dp[0][i]) {
				maxLen = dp[0][i];
				idx = i;
			}
		}
		
		System.out.println(maxLen);
		
		Stack<Integer> stack = new Stack();
		
		while(true) {
			stack.add(arr[idx]);
			if(dp[1][idx] == -1) break;
			idx = dp[1][idx];
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		
		System.out.println(sb);

	}

}