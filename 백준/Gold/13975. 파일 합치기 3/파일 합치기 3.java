import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine()); 
		
		
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine()); 
			
			PriorityQueue<Long> pq = new PriorityQueue<>(); 
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<N; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			long ans = 0; 
			while(pq.size() != 1) {
				long n1 = pq.poll(); 
				long n2 = pq.poll(); 
				
				long res = n1 + n2; 
				
				ans += res; 
				
				pq.add(res); 
			}
			
			
			sb.append(ans).append("\n"); 
		}
		
		System.out.println(sb);

	}

}


/*
 * 30 30 40 50  60 100 150
 * 70 80 150 
 * 
 * 60 40 50 
 * 
 * 
 * 
*/