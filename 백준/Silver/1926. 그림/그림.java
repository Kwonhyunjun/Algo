import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int cnt, area;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		area = 0; 
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1 && !v[r][c]) {
					cnt++;
					area = Math.max(area, dfs(r, c, 0));
				}
			}
		}
		System.out.println(cnt);
		System.out.println(area);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static int dfs(int r, int c, int curArea) {
		int size = 1; 
//		boolean isDone = true; 
//		for (int d = 0; d < 4; d++) {
//			int nr = r + dr[d];
//			int nc = c + dc[d];
//
//			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
//				continue;
//			if(map[nr][nc] == 1 && !v[nr][nc]) {
//				isDone = false; 
//			}
//		}
//		
//		if(isDone) {
//			area = Math.max(curArea, area);
//		}
//		
		v[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if(map[nr][nc] == 1 && !v[nr][nc]) {
				v[nr][nc] = true; 
				size += dfs(nr, nc, curArea+1);
			}

		}
		return size; 
	}

}