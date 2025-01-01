import java.io.*;
import java.util.*;

public class Main {
	
	static class Data{
		int w, cnt; 
		
		public Data(int w) {
			this.w = w; 
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		Integer[] cranes = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		Integer[] boxes = new Integer[M]; 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cranes, Collections.reverseOrder());
		Arrays.sort(boxes, Collections.reverseOrder());
		
//		System.out.println(Arrays.toString(cranes));
//		System.out.println(Arrays.toString(boxes));
		
		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				return o1.cnt - o2.cnt;
			}
		}); 
		
		if(cranes[0] < boxes[0]) {
			System.out.println(-1); 
			return; 
		}
		
		
		int idx = 0; 
		
		for(int cur : boxes) {
//			System.out.printf("cur : %d\n", cur);
			while(idx < N && cranes[idx] >= cur) {
//				System.out.printf("crane : %d\n", cranes[idx]);
				pq.offer(new Data(cranes[idx++])); 
			}
			
			Data crane = pq.poll();
			crane.cnt++; 
			pq.offer(crane); 
		}
		
		int answer = -1;
		while(!pq.isEmpty()) {
			answer = Math.max(pq.poll().cnt, answer);
		}
		
		System.out.println(answer);

	}

}