import java.io.*;
import java.util.*; 

public class Main {

	static int N, M, map[][], v[][],  r, c;
	static boolean[][] visited; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; 
		v = new int[N][M]; 
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(v[i], -1);
		}
		
		for(int i=0; i<N ; i++) { 
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					r = i; 
					c = j; 
				}else if(map[i][j] == 0) {
					v[i][j] = 0; 
				}
			}
		}
		
		
		bfs(r, c);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(v[i][j]).append(" "); 
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1}; 

	static void bfs(int sr, int sc) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		int depth = 0;
		
		q.offer(new int[] {sr, sc});
		v[sr][sc] = depth; 
		visited[sr][sc] = true;
		depth++; 
		
		while(!q.isEmpty()) {
			int size = q.size(); 
			
			for(int i=0; i<size; i++) {
				int[] cur = q.poll();
				
				for(int d=0; d<4; d++) {
					int nr = cur[0] + dr[d]; 
					int nc = cur[1] + dc[d]; 
					
		
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					
					q.offer(new int[] {nr, nc}); 
					visited[nr][nc] = true;
					v[nr][nc] = depth; 
				}
			}
			depth++; 
		}
	}
}