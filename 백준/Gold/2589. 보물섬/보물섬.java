import java.io.*;
import java.util.*;

public class Main {

	static int N, M, answer;
	static char map[][];
	static boolean v[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		answer = -1; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L') {
					v = new boolean[N][M];
					bfs(i, j);
				}
			}
		}
		
		System.out.println(answer);

	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static void bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		
		v[sr][sc] = true;
		q.offer(new int[] {sr, sc, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			answer = Math.max(answer, cur[2]);
//			System.out.println(cur[2]);
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(map[nr][nc] == 'W') continue; 
				if(v[nr][nc]) continue;
				
//				System.out.println("next : " + (cur[2] + 1));
				q.offer(new int[] {nr, nc, cur[2]+1});
				v[nr][nc] = true; 
			}
		}
	}
}