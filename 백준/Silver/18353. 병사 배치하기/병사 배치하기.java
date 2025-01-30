import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1; 
		
		for(int i=1; i<N; i++) {
			int max = -1; 
			for(int j=0; j<i; j++) {
				if(arr[i] < arr[j]) {
					max = Math.max(dp[j], max);
				}
			}
			
			
			dp[i] = (max == -1) ? 1 : max + 1;
		}
		
		int longest = -1; 
		for(int i=0; i<N; i++) {
			longest = Math.max(longest, dp[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		
		System.out.println(N-longest);

	}

}