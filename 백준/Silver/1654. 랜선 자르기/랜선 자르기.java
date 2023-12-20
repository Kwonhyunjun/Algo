import java.util.*;
import java.io.*;

public class Main {
	
	static int K, N, cables[]; 

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 

		
		st = new StringTokenizer(br.readLine()); 
		K = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken());
		
		cables = new int[K]; 
		
		for(int i=0; i<K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
		}
		
		long be = 1;
		long en = 0x7fffffff;
		
		while(be < en) {
			long mid = (be+en+1)/2;
			if(solve(mid)) be = mid;
			else en = mid - 1;
		}
		
		System.out.println(be);
	}

	private static boolean solve(long x) {
		long cur = 0;
		for(int i=0; i<K; i++) {
			cur += cables[i] / x;
		}
		return cur >= N ;
	}

}