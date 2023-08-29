import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	static int[][] homes; 
	static int ans; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		homes = new int[N][3]; 
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			homes[i][0] = Integer.parseInt(st.nextToken()); // R
			homes[i][1] = Integer.parseInt(st.nextToken()); // G
			homes[i][2] = Integer.parseInt(st.nextToken()); // B 
		}
		
		// Input End
		
		int[][] cost = new int[N][3];
		
		cost[0][0] = homes[0][0]; 
		cost[0][1] = homes[0][1]; 
		cost[0][2] = homes[0][2]; 
		
		for(int i = 1; i < N; i++) {
			cost[i][0] = homes[i][0] + Math.min(cost[i-1][1], cost[i-1][2]); 
			cost[i][1] = homes[i][1] + Math.min(cost[i-1][0], cost[i-1][2]); 
			cost[i][2] = homes[i][2] + Math.min(cost[i-1][0], cost[i-1][1]); 
		}
		
		System.out.println(Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]));
	}
	

}
