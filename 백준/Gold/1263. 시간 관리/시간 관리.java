import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine()); // 일의 개수
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0]; 
				return -(o1[1] - o2[1]);  
			}
		});
		
		int time = 0; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			time = Math.max(time, s); 
			pq.offer(new int[] {t, s}); 
		}
		
		time--; 
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll(); 
			int take = cur[0];
			int deadLine = cur[1]; 
//			System.out.printf("time : %d / cur : %d %d\n", time, take, deadLine);
			
			if(time >=  deadLine) {
				time = deadLine - 1;
			}
		
			time -= take;
		}
		
		int answer = (time < -1) ? -1 : time+1; 
		
		System.out.println(answer);
	}
}