import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		
		for(int i=N-1; i>=0; i--) {
			coins[i] = Integer.parseInt(br.readLine()); 
		}
		
		int answer = 0; 
		
		for(int i=0; i<N; i++) {
			if(total == 0) continue;
			answer += (total / coins[i]);
			
			total = total % coins[i];  
		}
		
		System.out.println(answer); 

	}

}