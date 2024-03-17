import java.util.*;
import java.io.*; 

public class Main {
	
	static int N, K, ans, arr[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		arr = new int[N][2];
		dp = new int[101][100001]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
			arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}
		
//		recur(0, 0, 0); 
//		System.out.println(ans);
		
//		System.out.println(recur2(0, 0));
		recur3(0, 0); 
//		for(int[] arr : dp)
//		System.out.println(Arrays.toString(arr));
		System.out.println(dp[0][0]);
	}
	
	// 백트레킹
	/**
	 * @param n 현재 보고있는 물건
	 * @param w 지금까지 담은 무게
	 * @param v 지금까지 담은 물건의 가치
	 */
	static void recur(int n, int w, int v) {
		if(w > K) return;
		
		if(n == N) {
			ans = Math.max(v, ans); 
			return;
		}
		
		// 현재 물건을 담는다.
		recur(n+1, w + arr[n][0], v+arr[n][1]);
		// 현재 물건을 담지 않는다.
		recur(n+1, w, v); 
	}
	
	// return 값 반환
	/**
	 * @param n 현재 보고있는 물건
	 * @param w 지금까지 담은 무게
	 * @return 남은 무게에서 얻을 수 있는 최대 가치
	 */
	static int recur2(int n, int w) {
		if(w > K) return Integer.MIN_VALUE;
		
		if(n == N) {
			return 0; // 물건을 다 봤으면 얻을 수 있는 가치는 0
		}
		
		return Math.max(recur2(n+1, w+arr[n][0]) + arr[n][1], recur2(n+1, w));
	}

	// 메모이제이션
//	static int[] dp; 
	static int[][] dp; 
	static int recur3(int n, int w) {
		
		if(w > K) return Integer.MIN_VALUE;
		
		if(n == N) {
			return 0;
		}
		
		if(dp[n][w] != 0) return dp[n][w]; 
		
		dp[n][w] = Math.max(recur3(n+1, w+arr[n][0]) + arr[n][1], recur3(n+1, w));
		return dp[n][w]; 
	}
}