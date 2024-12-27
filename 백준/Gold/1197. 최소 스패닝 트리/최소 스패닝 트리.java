import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E, parent[]; 
	static class Data{
		int v1, v2, weight; 
		
		public Data(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight; 
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.offer(new Data(v1, v2, weight)); 
		}
		
		parent = new int[V+1];
		Arrays.fill(parent, -1); 
		
		int cnt = 0;
		int answer = 0; 
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll(); 
			
			if(union(cur.v1, cur.v2)) {
//				System.out.println(cur.v1 + " " + cur.v2);
				answer += cur.weight;  
				cnt++; 
			}
			
			if(cnt == V-1) continue; 
		}
		
		System.out.println(answer);
	}
	
	static int find(int x) {
		if(parent[x] == -1) {
			return x; 
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
//		System.out.printf("%d %d %d %d\n", x, parentX, y, parentY);
		if(parentX == parentY) return false;
		
		parent[parentX] = parentY;
		
		return true;
	}

}