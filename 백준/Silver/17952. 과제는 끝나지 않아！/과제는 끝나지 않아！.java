import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				return -(o1.num - o2.num); 
			}
		}); 
		
		int answer = 0;
		Data cur = null;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int type = Integer.parseInt(st.nextToken());
			
			if(type == 1) {
				// 새로운 과제가 있면
				
				int score = Integer.parseInt(st.nextToken());
				int rest = Integer.parseInt(st.nextToken());
				
				if(cur == null) {
					cur = new Data(i, score, rest-1); 
				}else {
					pq.offer(cur); 
					cur = new Data(i, score, rest-1);
				}
				
			}else {
				// 새로운 과제가 없다면
				if(cur == null) {
					if(!pq.isEmpty()) {
						cur = pq.poll(); 
						cur.rest--;
					}
				} else {
					cur.rest--; 
				}
			}
			
			// 과제가 다 끝났다면
			
			if(cur != null && cur.rest == 0) {
				answer += cur.score; 
				cur = null; 
			}
		}
		
		System.out.println(answer); 
	}
	
	static class Data{
		int num, score, rest; 
		
		public Data(int num, int score, int rest) {
			this.num = num; 
			this.score = score; 
			this.rest = rest; 
		}
	}

}