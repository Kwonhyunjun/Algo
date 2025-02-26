import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; 
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		
		int maxLength = -1;
		for(int i=1; i<N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(arr[i] < arr[j]) continue;
				
				dp[i] = Math.max(dp[j]+1, dp[i]);
				maxLength = Math.max(maxLength, dp[i]); 
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		
//		System.out.println(maxLength);
		System.out.println(N-maxLength); 
		
	}

}