import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 10026. 적록색약
public class Main {
	static int N;
	static char[][] map;
	static boolean[][] v;
	static boolean[][] v1;
	static int ans1, ans2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		v = new boolean[N][N];
		v1 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// Input End
		
		bfs(); 
		bfs2(); 
		System.out.println(cnt+" "+cnt1);

	}

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	static int cnt = 0; 	// 일반
	static int cnt1 = 0; 	// 적록색약
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();	// 일반 

		// 시작위치
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j])
					continue;

				int color = map[i][j] == 'R' ? 0 : (map[i][j] == 'G' ? 1 : 2);
				q.offer(new int[] { i, j, color });
				v[i][j] = true;
				
				cnt++;
				while (!q.isEmpty()) {
					int[] cur = q.poll();

					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];

						if (nr >= 0 && nc >= 0 && nc < N && nr < N) {
							int nextColor = map[nr][nc] == 'R' ? 0 : (map[nr][nc] == 'G' ? 1 : 2);
							if(cur[2] == nextColor && !v[nr][nc]) {
								q.offer(new int[] {nr, nc, nextColor});
								v[nr][nc] = true; 
							}
						}
					}
				}
			}
		}
	}
	static void bfs2() {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 시작위치
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v1[i][j])
					continue;
				
				int color = map[i][j] == 'B' ? 0 : 1;
				q.offer(new int[] { i, j, color });
				v1[i][j] = true;
				
				cnt1++;
				while (!q.isEmpty()) {
					int[] cur = q.poll();
					
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						
						if (nr >= 0 && nc >= 0 && nc < N && nr < N) {
							int nextColor = map[nr][nc] == 'B' ? 0 : 1;
							if(cur[2] == nextColor && !v1[nr][nc]) {
								q.offer(new int[] {nr, nc, nextColor});
								v1[nr][nc] = true; 
							}
						}
					}
				}
			}
		}
	}
}
