import java.io.*;
import java.util.*;

public class Main {
	
	static class Data implements Comparable<Data> {
		int cnt;
		String name;
		
		public Data(String name, int cnt) {
			this.name = name; 
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Data o1) {
			if(this.cnt == o1.cnt) {
				return this.name.compareTo(o1.name);
			}
			
			return -(this.cnt - o1.cnt);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			map.put(st.nextToken(), 0);
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				String cur = st.nextToken();
				
				map.put(cur, map.get(cur)+1);
			}
		}
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(new Data(entry.getKey(), entry.getValue()));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			sb.append(cur.name).append(" ").append(cur.cnt).append("\n");
		}
		
		System.out.println(sb);

	}

}
