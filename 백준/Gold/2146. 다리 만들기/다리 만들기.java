import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[][] map;
	static int[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// Input End

		// 섬 마킹하기
		int mark = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (v[r][c] == 0 && map[r][c] == 1) {
					bfs(r, c, mark);
					mark++;
				}
			}
		}
//		for(int[] a : v) {
//			System.out.println(Arrays.toString(a));
//		}
//		System.out.println(mark);

		// 다리 잇기
		ans = Integer.MAX_VALUE;
		boolean[] done = new boolean[mark]; // 섬마다 연결 시도 여부 판단

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 바다면 pass
				if (map[r][c] == 0)
					continue;
				// 이미 연결 시도 했다면 pass
				if (done[v[r][c]])
					continue;

				makeBridge(r, c, new boolean[N][N]);
			}
		}
		System.out.println(ans);

	}

	private static void makeBridge(int r, int c, boolean[][] visited) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});

		// 시작점 넣기
		pq.offer(new int[] { r, c, 0 });
		visited[r][c] = true;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			// 육지이면서 다른 섬일 경우
			if (map[cur[0]][cur[1]] == 1 && v[cur[0]][cur[1]] != v[r][c]) {
				ans = Math.min(ans, cur[2]);
				return; 
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] +dr[d];
				int nc = cur[1] + dc[d];
				
				if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1)
					continue; // 범위 체크
				if(visited[nr][nc]) continue;
				
				if(map[nr][nc] == 0) { // 바다일 경우
					pq.offer(new int[] {nr,nc,cur[2]+1}); 
					visited[nr][nc] = true;
				}else {
					pq.offer(new int[] {nr,nc,cur[2]}); 
					visited[nr][nc] = true;
				}
			}

		}

	}

	private static void bfs(int r, int c, int mark) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c });
		v[r][c] = mark;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1)
					continue; // 범위 체크
				if (v[nr][nc] != 0 || map[nr][nc] == 0)
					continue; // 이미 방문했거나 바다일 경우

				q.offer(new int[] { nr, nc });
				v[nr][nc] = mark;
			}
		}

	}

}