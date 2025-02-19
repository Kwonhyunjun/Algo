import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[], answer;
	static int memo[][]; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1], dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			int max = 0;
			int min = 10001;
			
			for(int j=i; j>0; j--) {
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				
				dp[i] = Math.max(dp[i], max-min+dp[j-1]);
			}
		}
		
		System.out.println(dp[N]);
	
	}
}