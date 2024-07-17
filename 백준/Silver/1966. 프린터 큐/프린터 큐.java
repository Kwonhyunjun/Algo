import java.io.*;
import java.util.*; 

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int answer = 0; 
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
//			System.out.printf("t : %d\n", t); 
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 찾고 싶은 문서의 위치
			
			Queue<int[]> q = new ArrayDeque<>();
			int[] priorities = new int[N]; 
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				q.add(new int[] {i, priority});
				priorities[i] = priority; 
			}
			
			Arrays.sort(priorities);
//			System.out.println(Arrays.toString(priorities)); 
			
			int order = 1; 
			int idx = N-1; 
			while(!q.isEmpty()) {
				int[] cur = q.poll();
//				System.out.println("cur : " + Arrays.toString(cur)); 
				
				if(cur[1] == priorities[idx]) {
//					System.out.println("삭제");
					order++; 
					idx--; 
					if(cur[0] == M) {
//						System.out.println("찾던 값");
						System.out.println(order-1); 
						break; 
					}
				}else {
//					System.out.println("다시 넣음");
					q.add(cur); 
				}
			}
		}
	}
}