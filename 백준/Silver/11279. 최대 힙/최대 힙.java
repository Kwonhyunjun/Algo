import java.io.*; 
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		
		int N  = Integer.parseInt(br.readLine()); 
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return -(o1-o2);
			}
			
		}); 
		
		for(int i=0; i<N; i++) { 
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.add(num); 
			}
		}

		
		System.out.println(sb);
	}

}