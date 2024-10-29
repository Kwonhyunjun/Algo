import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
		int[][] lines = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken());
			
			lines[i][0] = start;
			lines[i][1] = end;
		}
		// Input End
		
		// 1. 선분 정렬 (끝점 ASC, 시작점 ASC)
		Arrays.sort(lines, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1]-o2[1]; 
				}
				
				return o1[0] - o2[0]; 
			}
		});
		
		// PQ 생성 
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1]; 
			}
		}); 
		
		// 초기화
		int answer = 1; 
		pq.offer(lines[0]);
		
		// 배열 순회
		for(int i=1; i<N; i++) {
			int[] cur = lines[i]; 
			
//			System.out.printf("현재 고려하는 선분 : %s\n", Arrays.toString(cur));
			
			// 겹치지 않는 선분 제거
			while(!pq.isEmpty() && cur[0] >= pq.peek()[1]) {
				pq.poll();
			}
			
			// 해당 선분 추가 
			pq.offer(cur);
			
//			for(int[] line : pq) {
//				System.out.printf("겹치는 선분 : %s\n", Arrays.toString(line));
//			}
			
			// 겹치는 개수 갱신
			answer = Math.max(answer, pq.size()); 
		}
		
		System.out.println(answer); 

	}

}