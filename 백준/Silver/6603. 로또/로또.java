import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[], ans[]; 
	static StringBuilder sb = new StringBuilder(); 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine()); 
			
			N = Integer.parseInt(st.nextToken()); 
			
			if(N == 0) break;
			
			arr = new int[N];
			ans = new int[6]; 
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); 
			}
			
			combi(0, 0); 
			
			sb.append("\n"); 
			
		}
		
		System.out.println(sb); 

	}
	
	static void combi(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				sb.append(ans[i]).append(" "); 
			}
			sb.append("\n"); 
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			ans[cnt] = arr[i];
			combi(cnt+1, i+1); 
		}
		
	}

}