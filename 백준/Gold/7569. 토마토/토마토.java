import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, H, map[][][]; 
	static boolean v[][][]; 
	static Queue<int[]> q = new ArrayDeque<>();
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		v = new boolean[H][N][M];
		
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
					
					if(map[h][n][m] == 1) {
						q.offer(new int[] {h, n, m});
						v[h][n][m] = true; 
					}
				}
			}
		}
		
		int answer = -1;
		if(isMature()) {
			answer = 0; 
		}else {
			int day = bfs()-1;
//			print();
			answer = (isMature()) ? day : -1; 
			
		}
		
		System.out.println(answer);
		
	}
	
	static int[] dh = new int[] {-1, 1, 0, 0, 0, 0};
	static int[] dr = new int[] {0, 0, 0, 0, -1, 1};
	static int[] dc = new int[] {0, 0, -1, 1, 0, 0};
	
	
	static int bfs() {
		int res = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			
			for(int i=0; i<size; i++) {
				int[] cur = q.poll();
				
				for(int d=0; d<6; d++) {
					int nh = cur[0] + dh[d];
					int nr = cur[1] + dr[d];
					int nc = cur[2] + dc[d];
					
					if(nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= N || nc >= M) continue;
					if(v[nh][nr][nc]) continue;
					if(map[nh][nr][nc] == 0) {
						q.offer(new int[] {nh, nr, nc});
						v[nh][nr][nc] = true;
						map[nh][nr][nc] = 1; 
					}
				}
			}
			
			res++;
			
		}
		
		
		return res; 
	}
	
	static boolean isMature() { 
		
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					
					if(map[h][n][m] == 0) {
						return false;
					}
				}
			}
		}
		
		return true; 
	}
	
	static void print() {
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				System.out.println(Arrays.toString(map[h][n]));
			}
		}
	}

}