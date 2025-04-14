import java.io.*;
import java.util.*;

public class Main {

	static int N, M, arr[][], answer;
	static boolean v[][];
	
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
		
		v = new boolean[N][M];
		
		solve(0, 0);

		System.out.println(answer);
	}
	
	static int[][] dr = new int[][]{
		{0, 1},
		{0, -1},
		{-1, 0},
		{0, 1}
	};
	static int[][] dc = new int[][]{
		{-1, 0},
		{-1, 0},
		{0, 1},
		{1, 0}
	};
	
	static void solve(int idx, int strength) {
		if(idx == N * M) {
			answer = Math.max(strength, answer); 
			return;
		}
		
		int curR = idx / M; 
		int curC = idx % M;
		
//		System.out.printf("arr[%d][%d] = %d, strength = %d\n", curR, curC, arr[curR][curC], strength);
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(v[i]));
//		}
//		System.out.println();
		
		
//		if(v[curR][curC]) {
//			solve(idx+1, strength);
//		}else {
			for(int d=0; d<5; d++) {
				if(d == 4) {
					solve(idx+1, strength);
				}else {
					int nr1 = curR + dr[d][0];
					int nc1 = curC + dc[d][0];
					
					int nr2 = curR + dr[d][1];
					int nc2 = curC + dc[d][1];
					
					if(nr1 < 0 || nr2 < 0 || nr1 >= N || nr2 >= N || nc1 < 0 || nc2 < 0 || nc1 >= M || nc2 >= M) continue;
					if(v[curR][curC] || v[nr1][nc1] || v[nr2][nc2]) continue;
//					System.out.println("d : " + d);
					v[nr1][nc1] = true;
					v[nr2][nc2] = true; 
					v[curR][curC] = true;
					
					solve(idx+1, strength+(arr[curR][curC] * 2) + arr[nr1][nc1] + arr[nr2][nc2]);
					
					v[nr1][nc1] = false;
					v[nr2][nc2] = false; 
					v[curR][curC] = false;					
				}
			}
			
//		}
		
	}

}