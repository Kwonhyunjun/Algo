import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] preSum = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			preSum[i] = preSum[i-1] + arr[i];
		}
		
		
//		System.out.println(Arrays.toString(preSum));

		
		int max = Integer.MIN_VALUE;
		for(int i=K; i<=N; i++) {
//			System.out.println(preSum[i] - preSum[i-K]);
			max = Math.max(preSum[i] - preSum[i-K], max);
		}
		
		System.out.println(max);
	}

}