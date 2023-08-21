import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 1987. 알파벳
public class Main {
	static int R, C;
	static char[][] map;
	static boolean[] v = new boolean[26]; // A(0) ~ Z(25)
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// Input End
		dfs(0, 0, 1);
		System.out.println(ans);

	}

	/**
	 * 
	 * @param r, c : 현재 밟은 위치
	 */

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int cnt) {
		// 현재 도착한 칸이 이전에 지나간 알파벳이라면
		if (v[(int) map[r][c] - 65])
			return;
		if(cnt > ans) {
			ans = cnt; 
		}
		// 방문 체크
		v[(int) map[r][c] - 65] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d]; 
			
			if(nr>=0 && nc>=0 && nr<R &&nc<C) {
				dfs(nr, nc, cnt+1); 
			}
		}
		v[(int) map[r][c] - 65] = false;

	}

}
