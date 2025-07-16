import java.io.*;
import java.util.*;

public class Main {
	
	static class Data implements Comparable<Data>{
		int age;
		String name;
		int order;
		
		public Data(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}

		@Override
		public int compareTo(Data o) {
			if(this.age == o.age) {
				return this.order - o.order;
			}
			return this.age - o.age;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			pq.offer(new Data(age, name, i));
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			sb.append(cur.age).append(" ").append(cur.name).append("\n");
		}
		
		System.out.println(sb);

	}

}
