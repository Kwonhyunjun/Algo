import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K; 
	static int map[][]; 
	static boolean[][] v; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine()); 
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine()); 
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			K = Integer.parseInt(st.nextToken()); // 배추 개수
			map = new int[N][M]; 
			v = new boolean[N][M]; 
			for(int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine()); 
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1; 
			}
			int size = 0 ; 
			for(int i = 0; i<N; i++) {
				for(int j = 0 ; j<M; j ++) {
					if(map[i][j] == 1 && !v[i][j]) {
						bfs(i, j);
						size++; 
					}
				}
			}
			
			System.out.println(size);
		}
		
		
	}

	static int[] dr = {-1, 1, 0, 0}; 
	static int[] dc = {0, 0, -1, 1}; 
	
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque();
		
		q.offer(new int[] {i, j}); 
		v[i][j] = true; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll(); 
			
			for(int d = 0 ; d < 4; d++) {
				int nr = cur[0] + dr[d]; 
				int nc = cur[1] + dc[d]; 
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
				if(map[nr][nc] != 1) continue;
				if(v[nr][nc]) continue;
				
				q.offer(new int[] {nr, nc});
				v[nr][nc] = true; 
			}
		}
		
	}
}
