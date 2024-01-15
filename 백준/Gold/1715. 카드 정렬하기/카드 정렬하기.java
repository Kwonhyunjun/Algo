import java.io.*; 
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		
		PriorityQueue<Long> pq = new PriorityQueue<>(); 
		
		int N = Integer.parseInt(br.readLine()); 
		
		for(int i=0; i<N; i++){
			pq.add(Long.parseLong(br.readLine())); 
		}
		
		long ans = 0; 
		
		while(pq.size() != 1) {
			
			long a = pq.poll(); 
			long b = pq.poll(); 
			
			pq.add(a+b);
			ans += (a+b); 
			
//			System.out.println(pq); 
		}
		
		System.out.println(ans); 

	}

}