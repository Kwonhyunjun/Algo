import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans; 
	static char[][] map;
	static int sr, sc; 
	static Queue<int[]> water;
	static boolean[][] v; 
	static int[][] waterV; 
	static boolean[][] visited; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C]; 
		v = new boolean[R][C];
		visited = new boolean[R][C];
		waterV = new int[R][C];
		for(int[] a : waterV) {
			Arrays.fill(a, -1);
		}
		water = new ArrayDeque(); 
		
		for(int r=0; r<R; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				if(map[r][c] == '*') {
					water.offer(new int[] {r, c});
					visited[r][c] = true; 
				}else if(map[r][c] == 'S') {
					sr = r; 
					sc = c; 
				}
			}
		}
		// Input End
		ans = Integer.MAX_VALUE; 
		flood();
//		for(int[] a : waterV) {
//			System.out.println(Arrays.toString(a));
//		}
		move(); 
		System.out.println(ans == Integer.MAX_VALUE? "KAKTUS" : ans-1);
	}

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1}; 
	
	private static void move() {
		int cnt = 0 ; 
		Queue<int[]> q = new ArrayDeque(); 
		
		// 시작 위치
		q.offer(new int[] {sr, sc});
		v[sr][sc] = true; 
		
		int size; 
		while(!q.isEmpty()) {
			size = q.size(); 
			cnt++; 
			
			for(int i=0; i<size; i++) {
				int[] cur= q.poll(); 
				if(map[cur[0]][cur[1]] == 'D' ) ans = cnt; 
				
				for(int d=0; d<4; d++) {
					int nr = cur[0] + dr[d]; 
					int nc = cur[1] + dc[d]; 
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue; // 범위
					if(v[nr][nc]) continue; // 방문체크
					if(waterV[nr][nc] != -1 && waterV[nr][nc] <= cnt) continue; 
					if(map[nr][nc] == 'X') continue; 
					
					q.offer(new int[] {nr, nc});
					v[nr][nc] = true; 
				} 
			}
		}
	}

	private static void flood() {
		int cnt = 0 ; 
		
		// 시작 위치	
		int size; 
		while(!water.isEmpty()) {
			size = water.size(); 
			
			for(int i=0; i<size; i++) {
				int[] cur= water.poll(); 
				waterV[cur[0]][cur[1]] = cnt; 
				visited[cur[0]][cur[1]] = true; 
				
				for(int d=0; d<4; d++) {
					int nr = cur[0] + dr[d]; 
					int nc = cur[1] + dc[d]; 
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue; 	
					if(visited[nr][nc]) continue; 
					if(map[nr][nc] == 'D' || map[nr][nc] == 'X') continue; 
					
					water.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
			cnt++; 
		}
		
	}

}