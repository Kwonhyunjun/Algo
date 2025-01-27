import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		int answer = arr[0];
	
		Arrays.fill(dp, Integer.MIN_VALUE);
		
		dp[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			answer = Math.max(dp[i], answer);
		}
		
		System.out.println(answer);
	}

}