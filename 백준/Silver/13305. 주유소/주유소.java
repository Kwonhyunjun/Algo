import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dist = new long[N]; 
		long[] gas = new long[N]; 
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=1; i<N; i++) {
			dist[i] = Long.parseLong(st.nextToken()); 
		}
		
//		System.out.println(Arrays.toString(dist)); 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			gas[i] = Long.parseLong(st.nextToken()); 
		}
		
		long[] dp = new long[N]; 
		
		Arrays.fill(dp, Long.MAX_VALUE); 
		
		dp[0] = 0; 
		
//		for(int i=1; i<N; i++) {
//			
//			for(int j=i-1; j>=0; j--) {
////				System.out.printf("%d %d => 거리 %d, 가스비 %d\n", i, j, (dist[i]-dist[j]), gas[j]);
////				System.out.printf("이전 도시에서 든 가스 비용 %d + 이전 도시에서 현재 도시까지 가시비용 %d\n", dp[j], ((dist[i]-dist[j]) * gas[j])); 
//				dp[i] = Math.min(dp[i], dp[j] +  ((long) (dist[i]-dist[j]) * gas[j]) ); 
//				
//			}
//			
//		}
	
//		System.out.println(Arrays.toString(dp));
//		System.out.println(dp[N-1]);
	
		long curGas = gas[0]; 
		long answer = 0; 
//		System.out.println(Arrays.toString(dist)); 
//		System.out.println(Arrays.toString(gas)); 
				
		for(int i=1; i<N; i++) {
			curGas = (curGas > gas[i-1]) ? gas[i-1] : curGas; 
//			System.out.printf("현재가스 %d 거리%d\n", curGas, dist[i]);
			
			answer += (dist[i] * curGas);
		}
		
		System.out.println(answer);

	}

}