import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine());
		
		long N = Integer.parseInt(st.nextToken()); 
		long M = Integer.parseInt(st.nextToken()); 
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pq.add(Long.parseLong(st.nextToken())); 
		}
		
		for(int i=0; i<M; i++) {
			long a = pq.poll(); 
			long b = pq.poll(); 
			
			long temp = a+b; 
			
			pq.add(temp); 
			pq.add(temp); 
		}
		
		long sum = 0; 
		while(pq.size() > 0) {
			sum += pq.poll(); 
		}
		
		System.out.println(sum); 
		
	}
}