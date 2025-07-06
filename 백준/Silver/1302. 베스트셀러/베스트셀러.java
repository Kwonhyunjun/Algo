import java.io.*;
import java.util.*;

public class Main {
	
	static class Data implements Comparable<Data>{
		int cnt;
		String str;
		
		public Data(String str, int cnt) {
			this.str = str;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Data o1) {
			if(this.cnt == o1.cnt) {
				return this.str.compareTo(o1.str);
			}
			
			return -(this.cnt - o1.cnt);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String cur = br.readLine();
			
			map.put(cur, map.getOrDefault(cur, 0)+1);
		}
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		
		for(Map.Entry<String , Integer> entry : map.entrySet()) {
			pq.offer(new Data(entry.getKey(), entry.getValue())); 
		}
		
		System.out.println(pq.peek().str);
	}
}