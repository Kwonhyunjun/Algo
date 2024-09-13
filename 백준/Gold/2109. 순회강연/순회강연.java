import java.io.*;
import java.util.*; 

public class Main {
	 
	static Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		List<Data> list = new ArrayList<>();
		PriorityQueue<Data> pq = new PriorityQueue<>();
		
		int max = 0; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, day); 
			list.add(new Data(day, pay)); 
		}
		
		for(Data d : list) {
			pq.add(d); 
		}
		
		boolean[] checked = new boolean[max+1]; 
		
		int result = 0; 
		while(!pq.isEmpty()) {
			Data d = pq.poll(); 
			
			for(int i = d.day; i>0; i--) {
				if(!checked[i]) {
					checked[i] = true;
					result += d.pay;
					break; 
				}
			}
		}
		
		System.out.println(result); 
		
		
	}
	
	static class Data implements Comparable<Data>{
		int day, pay; 
		
		public Data(int day, int pay) {
			this.day = day;
			this.pay = pay; 
		}
		
		@Override
		public int compareTo(Data o1) {
			if(o1.pay == this.pay) {
				return this.day - o1.day; 
			}
			
			return -(this.pay - o1.pay); 
		}
	}

}