import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, M, map[][]; 
	static boolean[][] v; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int answer = 0; 
		
		for(int i=0; i<N; i++) { 
			
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1 && !v[i][j]) {
					answer++; 
//					System.out.println("시작" + i + " " + j);
					bfs(i, j);
				}
			}
		}
		
		System.out.println(answer);

	}
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static void bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {sr, sc});
		v[sr][sc] = true; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll(); 
//			System.out.println(cur[0] + " " + cur[1]);
			
			for(int d=0; d<8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
				if(map[nr][nc] == 0 || v[nr][nc]) continue; 
				
				q.offer(new int[] {nr, nc});
				v[nr][nc] = true; 
			}
		}
		
	}

}