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
				if(checkSurroundings(i, j) && !v[i][j]) {
//					System.out.println(i + " " + j);
					if(solve(i, j)) answer++;
//					for(int k=0; k<N; k++) {
//						System.out.println(Arrays.toString(v[k]));
//					}
				}
			}
		}

		System.out.println(answer);
	}
	
	static boolean solve(int r, int c) {
		boolean[][] tempV = new boolean[N][M];
		List<int[]> submit = new ArrayList<>();
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c, map[r][c]});
		submit.add(new int[] {r, c});
		tempV[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d=0; d<8; d++) {
				int nr = cur[0]+dr[d];
				int nc = cur[1]+dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(tempV[nr][nc]) continue;
				if(map[nr][nc] > cur[2]) return false;
				if(map[nr][nc] < cur[2]) continue;
				submit.add(new int[] {nr, nc});
				tempV[nr][nc] = true;
				q.offer(new int[] {nr, nc, map[nr][nc]});
			}
		}
		
		for(int[] s : submit) {
//			System.out.println(Arrays.toString(s));
			v[s[0]][s[1]] = true;
		}
		
		return true;
	}
	
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	static boolean checkSurroundings(int r, int c) {
		int cur = map[r][c];
		
		for(int d=0; d<8; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			
			if(map[nr][nc] > cur) return false;
		}
		
		return true;
	}

	
}