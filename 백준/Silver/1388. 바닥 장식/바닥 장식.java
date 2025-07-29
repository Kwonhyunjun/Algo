import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, answer;
	static char[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		v = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!v[i][j]) {
					bfs(i, j);
					answer++;
				}
			}
		}
		
		System.out.println(answer);

	}
	
	
	static int[] gadr = {0, 0};
	static int[] gadc = {-1, 1};
	static int[] sedr = {-1, 1};
	static int[] sedc = {0, 0};
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		v[r][c] = true;
		
		char type = map[r][c];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<2; d++) {
				int nr = cur[0] + ((type == '-') ? gadr[d] : sedr[d]);
				int nc = cur[1] + ((type == '-') ? gadc[d] : sedc[d]);
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(v[nr][nc]) continue;
				if(map[nr][nc] != type) continue;
				
				q.offer(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
		
	}

}
