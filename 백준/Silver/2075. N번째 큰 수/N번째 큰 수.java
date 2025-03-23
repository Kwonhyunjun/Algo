import java.io.*;
import java.util.*;

public class Main {

	static int N, map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> -(o1[0]-o2[0]));
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == N-1) {
					pq.offer(new int[] {map[i][j], i, j});
				}
			}
		}
		
		int cnt = 0;
		while(cnt < N) {
			int[] cur = pq.poll();
//			System.out.println(Arrays.toString(cur));
			
			if(cnt == N-1) {
				System.out.println(cur[0]);
				break;
			}
			
			int nr = cur[1] -1;
			int nc = cur[2];
			if(nr >= 0) {
				pq.offer(new int[] {map[nr][nc], nr, nc});
			}
			cnt++;
		}
		

	}

}