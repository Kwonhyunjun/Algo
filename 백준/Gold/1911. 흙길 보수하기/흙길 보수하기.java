import java.io.*;
import java.util.*;

public class Main {
	
	static int N, L; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 물 웅덩이 개수
		L = Integer.parseInt(st.nextToken()); // 널빤지의 길이
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		
		int cnt = 0; // 사용한 널빤지 개수
		int pointer = 0; // 널빤지를 놓을 위치
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {s, e-1});
		}
		
		pointer = pq.peek()[0];
		
		while(!pq.isEmpty()) {
			// 만약 포인터가 덮어야 할 웅덩이를 지났을 경우 해당 웅덩이 제외
			while(!pq.isEmpty() && pointer > pq.peek()[1]) {
				pq.poll(); 
			}
			
			if(pq.isEmpty()) break; 
			
			// 포인터가 덮어야 할 웅덩이 전을 가리킬 경우
			if(pointer < pq.peek()[0]) pointer = pq.peek()[0];
			
			// 널빤지 덮기
			pointer += L;
			cnt++; 
		}
		
		System.out.println(cnt);

	}

}