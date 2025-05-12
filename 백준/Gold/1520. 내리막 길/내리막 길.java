import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, arr[][], dp[][], answer;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][M];
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[N-1][M-1] = 1;
		
		v = new boolean[N][M];
		
		System.out.println(solve(0, 0));
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
	}
	
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, -1, 0, 1};
	static int solve(int r, int c) {
		
		
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		
		int res = 0;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(v[nr][nc]) continue;
			if(arr[r][c] <= arr[nr][nc]) continue;
			v[nr][nc] = true;
			res += solve(nr, nc);
			v[nr][nc] = false;
		}
		
//		System.out.printf("arr[%d][%d] = %d\n", r, c, res);
		
		return dp[r][c] = res;
	}

}