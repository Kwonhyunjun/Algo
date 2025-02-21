import java.io.*;
import java.util.*;

public class Main {
	
	static class Point implements Comparable<Point>{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if(this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			pq.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); 
		}
		
		StringBuilder sb = new StringBuilder(); 
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			sb.append(p.x).append(" ").append(p.y);
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}