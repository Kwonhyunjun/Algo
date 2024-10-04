import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, M, sr, sc;
	static boolean[][] v; 
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		v = new boolean[N][M]; 
		
		for(int i=0; i<N; i++) { 
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'I') {
					sr = i;
					sc = j; 
				}
			}
		}
		
		int cnt = solve(); 
		
		if(cnt == 0) {
			System.out.println("TT");
		}else {
			System.out.println(cnt); 
		}

	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1}; 
	
	public static int solve() {
		int res = 0;
		
		Queue<int[]> q = new ArrayDeque<>(); 
		q.offer(new int[] {sr, sc});
		v[sr][sc] = true; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(map[cur[0]][cur[1]] == 'P') res++; 
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d]; 
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(v[nr][nc]) continue; 
				if(map[nr][nc] == 'X') continue;
				
				q.offer(new int[] {nr, nc});
				v[nr][nc] = true; 
			}
		}
		
		
		return res; 
	}

}