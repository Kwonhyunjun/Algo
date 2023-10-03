import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		System.out.println(N+M);
		System.out.println(N-M);
		System.out.println(N*M);
		System.out.println(N/M);
		System.out.println(N%M);
		
	}


}