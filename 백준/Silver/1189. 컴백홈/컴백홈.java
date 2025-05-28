import java.io.*;
import java.util.*;

public class Main {

	static int R, C, K, answer; 
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int r=0; r<R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		boolean[][] v = new boolean[R][C];
		v[R-1][0] = true;
		solve(R-1, 0, 1, v);
	
		System.out.println(answer);
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static void solve(int r, int c, int depth, boolean[][] v) {
//		System.out.printf("r : %d, c : %d, depth : %d \n", r, c, depth);
		if(r == 0 && c == C-1) {
//			System.out.printf("도착 :: r : %d, c : %d, depth : %d \n", r, c, depth);
			if(depth == K) {
				answer++;
			}
			return; 
		}
	
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
//			System.out.println(1);
			if(map[nr][nc] == 'T') continue;
//			System.out.println(2);
			if(v[nr][nc]) continue;
//			System.out.println(3);
			
			v[nr][nc] = true;
			solve(nr, nc, depth+1, v);
			v[nr][nc] = false;
		}
	}

}