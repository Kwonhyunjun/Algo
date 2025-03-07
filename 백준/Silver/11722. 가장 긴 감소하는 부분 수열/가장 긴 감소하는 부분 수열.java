import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		for(int i=1; i<N; i++) {
			int max = -1; 
			for(int j=0; j<i; j++) {
				if(arr[i] < arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			
			if(max != -1) dp[i] = max + 1; 
		}
		
		
		int answer = -1;
		for(int i=0; i<N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(answer);

	}

}