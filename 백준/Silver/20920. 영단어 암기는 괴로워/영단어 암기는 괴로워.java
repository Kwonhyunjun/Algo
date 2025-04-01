import java.io.*;
import java.util.*; 

public class Main {
	
	static class Data implements Comparable<Data>{
		String str; 
		int cnt;
		
		public Data(String str , int cnt) {
			this.cnt = cnt;
			this.str = str; 
		}
		
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			if(this.cnt == o.cnt) {
				int thisLen = this.str.length(); 
				int oLen = o.str.length();
				if(thisLen == oLen) {
					return this.str.compareTo(o.str);
				}
				return -(thisLen - oLen); 
			}
			return -(this.cnt - o.cnt);
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String cur = br.readLine();
			
			if(cur.length() < M) continue;
			
			map.put(cur, map.getOrDefault(cur, 0) + 1);
		}
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(new Data(entry.getKey(), entry.getValue()));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll().str).append("\n");
		}
		
		System.out.println(sb);

	}

}