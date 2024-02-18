import java.io.*; 
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); 
		st = new StringTokenizer(br.readLine()); 
		int cnt = 0; 
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken()); 
			
			if(num < 2) continue;
			
			if(num == 2) {
				cnt++;
				continue;
			}
			
			boolean isPrime = true; 
			
			for(int j=2; j<=Math.sqrt(num); j++) {
				if(num % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) cnt++; 
			
		}

		System.out.println(cnt);
	}

}