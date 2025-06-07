import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, whitePower, bluePower;
	static char[][] map;
	static boolean[][] v; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[M][N];
		v = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(v[i][j]) continue;
				getPower(i, j);
			}
		}
		
		System.out.println(whitePower + " " + bluePower); 
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void getPower(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		v[r][c] = true;
		
		char curTeam = map[r][c];
		int many = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			many++;
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
				if(map[nr][nc] != curTeam) continue;
				if(v[nr][nc]) continue;
				
				q.offer(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
		
		int power = (int) Math.pow(many, 2);
		if(curTeam == 'W') {
			whitePower += power;
		}else {
			bluePower += power; 
		}
	}

}