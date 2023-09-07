import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N+1][M+1];
		v = new boolean[N+1][M+1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		int ans = Integer.MIN_VALUE; 
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < M+1; c++) {
				if (map[r][c] == 1 && !v[r][c]) {
					ans = Math.max(ans, bfs(r, c));
				}
				
			}
		}
		System.out.println(ans);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static int bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque();

		q.offer(new int[] { sr, sc });
		v[sr][sc] = true;

		int cnt = 0; 
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			cnt++; 
			
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr > N || nc > M) continue;
				if(map[nr][nc] != 1) continue;
				if(v[nr][nc]) continue;
				
				q.offer(new int[] {nr, nc});
				v[nr][nc] = true; 
			}
		}

//		for(boolean[] b : v) {
//			System.out.println(Arrays.toString(b));
//		}
//		System.out.println();
		return cnt; 
	}
}