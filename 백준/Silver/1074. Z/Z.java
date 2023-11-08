import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, R, C, map[][], ans;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(sc.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
			
		int s = (int) Math.pow(2, N); 
//		map = new int[s][s]; 
		
		System.out.println(solve(N, R, C)); 
	}

	static int solve(int n, int r, int c) {
		if(n == 0) {
			 return 0; 
		}
		
		int half = (int) Math.pow(2, n-1);
		
		if(r < half && c <half) {
			return solve(n-1, r, c); 
		}else if(r < half && c >= half) {
			return half*half + solve(n-1, r, c -half); 
		}else if(r >= half && c < half) {
			return 2*half*half + solve(n-1, r-half, c); 
		}else {
			return 3*half*half + solve(n-1, r-half, c-half); 
		}
		
	}
}