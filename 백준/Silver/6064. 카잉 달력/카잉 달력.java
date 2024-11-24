import java.io.*;
import java.util.*;

public class Main {
	
	static int T, M, N, x, y; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			
			int end = lcm(M, N);
			int answer = -1;
			
			while(x <= end) {
				
				
				if(x - y >= 0) {
					if((x-y) % N == 0) {
						answer = x; 
						break; 
					}
				}
				
				x += M;
				
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	
	static int lcm(int a, int b) {
		return (a * (b/ gcd(a,b)));
	}

}