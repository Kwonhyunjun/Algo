import java.io.*;
import java.util.*;

public class Main {
	
	static int N, r1, c1, r2, c2; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		v = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(v[i], Integer.MAX_VALUE);
		}
		
		solve();
		
		System.out.println((v[r2][c2] == Integer.MAX_VALUE) ? -1 : v[r2][c2]);

	}
	
	static int[][] v;
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};  
	
	static void solve() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r1, c1, 0});
		v[r1][c1] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<6; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int nxt = cur[2] + 1;
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(v[nr][nc] <= nxt) continue;
				
				q.offer(new int[] {nr, nc, nxt});
				v[nr][nc] = nxt;
			}
		}
	}

}