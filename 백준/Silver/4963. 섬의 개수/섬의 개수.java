import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; 
	static int[][] map; 
	static boolean[][] v; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken()); 
			
			if(M == 0 && N == 0) break;
			
			map = new int[N][M];
			v = new boolean[N][M]; 
			int island = 0; 
			
			for(int r = 0 ; r<N; r++) {
				st = new StringTokenizer(br.readLine());				
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int r = 0 ; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[r][c] == 1 && !v[r][c]) {
						bfs(r, c); 
						island++; 
					}
				}
			}
			System.out.println(island);
		}
	}

	static int[] dr = {-1, 0, 1, 0, -1, 1, 1, -1}; 
	static int[] dc = {0, 1, 0 , -1, -1, 1, -1, 1}; 
	
	private static void bfs(int r, int c) {
		
		Queue<int[]> q = new ArrayDeque(); 
		q.offer(new int[] {r, c}); 
		v[r][c] = true; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d =0; d<8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) 	continue;
				if(map[nr][nc] ==1 && !v[nr][nc]) {
					q.offer(new int[] {nr, nc}); 
					v[nr][nc] = true; 
				}
			}
		}
		
	}

}