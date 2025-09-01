import java.io.*; 
import java.util.*;

public class Main {
	
	static int N;
	static long memo[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		memo = new long[N+1];
		Arrays.fill(memo, -1);
		
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println(fibbo(N));

	}
	
	static long fibbo(int N) {
		if(memo[N] != -1) {
			return memo[N];
		}
		
		return memo[N] = fibbo(N-2) + fibbo(N-1); 
		
	}

}
