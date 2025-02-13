import java.io.*;
import java.util.*;

public class Main {
	
	static class Data{
		int start, end; 
		
		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				
				return o1[0] - o2[0];
			}
		}); 
		
		List<Integer> blueAnswer = new ArrayList<>();
		List<Integer> redAnswer = new ArrayList<>();
		
		int blueEndTime = 0; 
		int redEndTime = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			int color = (st.nextToken().equals("B")) ? 0 : 1;
			int count = Integer.parseInt(st.nextToken());
			
			if(color == 0) {
				time = (time < blueEndTime) ? blueEndTime : time;
			}else {
				time = (time < redEndTime) ? redEndTime : time;
			}
			
			int duration = (color == 0) ? A : B;
			
			for(int j=0; j<count; j++) {
				int start = time + (duration * j);
				pq.offer(new int[]{start ,color});
				if(color == 0) {
					blueEndTime = start + duration;
				}else {
					redEndTime = start + duration;
				}
			}
		}
		
		int idx = 1;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			List<Integer> list = (cur[1] == 0) ? blueAnswer : redAnswer;
			list.add(idx++);
		}

		
		StringBuilder sb = new StringBuilder();
		sb.append(blueAnswer.size()).append("\n");
		for(int cur : blueAnswer) {
			sb.append(cur).append(" "); 
		}
		sb.append("\n");
		sb.append(redAnswer.size()).append("\n");
		for(int cur : redAnswer) {
			sb.append(cur).append(" "); 
		}
		
		System.out.println(sb);
	}

}