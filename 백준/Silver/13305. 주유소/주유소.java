import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dist = new int[N]; 
		int[] gas = new int[N]; 
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=1; i<N; i++) {
			dist[i] = Integer.parseInt(st.nextToken()) + dist[i-1]; 
		}
		
//		System.out.println(Arrays.toString(dist)); 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			gas[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int[] dp = new int[N]; 
		
		Arrays.fill(dp, Integer.MAX_VALUE); 
		
		dp[0] = 0; 
		
		for(int i=1; i<N; i++) {
			
			for(int j=i-1; j>=0; j--) {
//				System.out.printf("%d %d => 거리 %d, 가스비 %d\n", i, j, (dist[i]-dist[j]), gas[j]);
//				System.out.printf("이전 도시에서 든 가스 비용 %d + 이전 도시에서 현재 도시까지 가시비용 %d\n", dp[j], ((dist[i]-dist[j]) * gas[j])); 
				dp[i] = Math.min(dp[i], dp[j] + ((dist[i]-dist[j]) * gas[j]) ); 
				
			}
			
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N-1]);
	}

}