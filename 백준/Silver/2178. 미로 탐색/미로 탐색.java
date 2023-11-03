import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N, M; // 행, 열개수
	static int[][] map; // 2차원 타일맵
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M]; // 1,1에서 시작한다고 했으니 [N+1][M+1]
		v = new int[N][M];
		ans = Integer.MAX_VALUE;
		String s;
		for (int i = 0; i < N; i++) {
			s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0'; // char형 -> int형 변환(char '0' == int 48)
			}
		}
		// Input End

		bfs();

		// Output start
		System.out.println(ans);
//		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans); // 만약 원하는 답을 얻지 못하는 경우
	}

	static int[] dx = { 0, 0, -1, 1 }; // 상 하 좌 우
	static int[] dy = { -1, 1, 0, 0 }; // B형 - 따로 처리 
	static int[][] v; // 방문 체크 배열

	private static void bfs() {
		Queue<Data> q = new ArrayDeque<>();


		q.offer(new Data(0, 0)); 
		v[0][0] = 1;

		Data cur;
		int size = 0 ; 
		int cnt = 0; 
		while (!q.isEmpty()) {
			size = q.size(); 
			cnt++; 
			for(int i=0; i<size; i++) {
				cur = q.poll();
				// 도착지 여부 판단
				if (cur.x == M - 1 && cur.y == N - 1) {
					ans = v[cur.y][cur.x]+1; // 수정 
					break; 
				}
				
				int nx, ny; 
				for (int d = 0; d < 4; d++) { 
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
					if(nx < 0 || nx >= M || ny <0 || ny >=N) continue; 
					if(v[ny][nx] != 0) continue; // 수정 
					if(map[ny][nx] == 0) {
						continue; 
					}
					q.offer(new Data(nx, ny));
					v[ny][nx] = cnt; // 수정 
				}
			}
		}
	}

	static class Data {
		int x, y;

		public Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
