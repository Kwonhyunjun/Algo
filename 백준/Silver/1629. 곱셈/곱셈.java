import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long A, B, C, ans;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(sc.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(solve(A, B, C));
	}

	static long solve(long a, long b, long m) {
		if(b==1) return a%m; 
		long val = solve(a, b/2, m); 
		val = val * val %m; 
		if(b%2 == 0) return val; 
		return val * a %m; 
		
	}
}