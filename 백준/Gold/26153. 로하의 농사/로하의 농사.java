import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, map[][], sr, sc, P, answer; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		boolean[][] visited = new boolean[N][M];
		visited[sr][sc] = true;
		
		answer = map[sr][sc];
		
		solve(sr, sc, P, -1, visited, map[sr][sc]); 
		
		System.out.println(answer);
		
	}
	
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static void solve(int r, int c, int p, int dir, boolean[][] v, int water) {
		if(p == 0) {
			answer = Math.max(water, answer);
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			answer = Math.max(water, answer);
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(v[nr][nc]) continue; 
			
			int need = (dir == d || dir == -1) ? 1 : 2; 
			if(p < need) continue; 
			
			v[nr][nc] = true;
			solve(nr, nc, (p-need), d, v, water+map[nr][nc]);
			v[nr][nc] = false;
		}
	}
	
	static int countPipe(int curDir, int nextDir) {
		int res = 0;
		
		
		
		return res; 
	}

}