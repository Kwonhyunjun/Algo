import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, parents[]; 
	static class Data{
		int a, b, cost; 
		
		public Data(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		Arrays.fill(parents, -1);
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Data(a, b, cost));
		}
		
		int connected = 0;
		int answer = 0;
		
		while(!pq.isEmpty() && connected < N-1) {
			Data cur = pq.poll();
			
//			System.out.println(Arrays.toString(parents));
//			System.out.printf("%d-%d : %d\n", cur.a, cur.b, cur.cost);
			
			if(union(cur.a, cur.b)) {
				connected++;
				answer += cur.cost;
			}
		}
		
		System.out.println(answer);

	}
	
	static int find(int x) {
//		System.out.println("find : " + x);
		if(parents[x] == -1) {
			return x; 
		}
		
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		int parentX = find(x);
//		System.out.println("union : " + x);
		int parentY = find(y);
//		System.out.println("union : " + y);
		
		if(parentX == parentY) return false;
		
		parents[parentX] = parentY; 
		return true;
	}

}