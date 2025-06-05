import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
	static class Data{
		int num, start, end;
		
		public Data(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Data[] times = new Data[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			times[i] = new Data(num, start, end); 
		}
		
		Arrays.sort(times, (o1, o2) -> o1.start - o2.start);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(times[0].end);
		
		for(int i=1; i<N; i++) {
			Data cur = times[i];
			
			if(pq.peek() <= cur.start) {
				pq.poll();
			}
			
			pq.add(cur.end);
		}
		
		
		System.out.println(pq.size());

	}

}