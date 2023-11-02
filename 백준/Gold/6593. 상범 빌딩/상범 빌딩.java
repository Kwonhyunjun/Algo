import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int L, R, C; 
	static char[][][] map; 
	static boolean[][][] v; 
	static int ans; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) break; 
			
			map = new char[L][R][C];
			v = new boolean[L][R][C];
			
			for(int l = 0; l < L; l++) {
				for(int r = 0; r < R; r++) {
					map[l][r] = br.readLine().toCharArray(); 
				}
				br.readLine(); 
			}
			// Input End
			int[][] index = new int[2][3]; 
			
			for(int l = 0; l < L; l++) {
				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						
						if(map[l][r][c] == 'S') {
							index[0][0] = l; 
							index[0][1] = r; 
							index[0][2] = c; 
						
						}
						
						if(map[l][r][c] == 'E') {
							index[1][0] = l; 
							index[1][1] = r; 
							index[1][2] = c; 
						}
						 
					}
				}
			}
			
			ans = 0 ; 
			bfs(index); 
			if(ans == 0) {
				System.out.println("Trapped!");
			}else {
				System.out.printf("Escaped in %d minute(s).\n", ans);
			}
		}
		
		
	}

	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	
	private static void bfs(int[][] index) {
		Queue<int[]> q = new ArrayDeque(); 
		
		q.offer(index[0]);
		
		int size = 0; 
		int min = 0; 
		
		while(!q.isEmpty()) {
			size = q.size(); 
			min++; 
			
			for(int i = 0; i < size; i++) {
				int[] cur = q.poll();
				
				if(cur[0] == index[1][0] && cur[1] == index[1][1] && cur[2] == index[1][2]){
					ans = min-1; 
					return; 
				}
				
				for(int d=0; d<6; d++) {
					int nh = cur[0] + dh[d];
					int nr = cur[1] + dr[d];
					int nc = cur[2] + dc[d];
					
					if(nh < 0 || nr < 0 || nc < 0 || nh >= L || nr >= R || nc >= C) continue; 
					if(map[nh][nr][nc] == '#' || map[nh][nr][nc] == 'S') continue; 
					
					map[nh][nr][nc] = 'S'; 
					q.offer(new int[] {nh, nr, nc}); 
				}
			}
		}
	}
}
