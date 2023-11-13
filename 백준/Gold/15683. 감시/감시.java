import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static List<int[]> cctvs; 

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M]; 
		cctvs = new ArrayList<>(); 
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());			
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken()); 
				
				if(map[r][c] > 0 && map[r][c] < 6) {
					cctvs.add(new int[] {map[r][c], r, c}); 
				}
			}
		}
		
		ans = Integer.MAX_VALUE; 
		if(cctvs.isEmpty()) {
			int s = 0; 
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					if(map[r][c] == 0) {
						s++; 
					}
				}
			}
			ans = s;
			System.out.println(ans);
		}else {
			solve(0, map);
			System.out.println(ans == Integer.MAX_VALUE? 0 : ans);			
		}
	}

	 
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static void solve(int cnt ,int[][] mapCopy) {
		if(cnt == cctvs.size()) { 
			

//			System.out.println(cnt);
//			for(int[] i : mapCopy) {
//				System.out.println(Arrays.toString(i));
//			}
//			System.out.println();
			// 모든 cctv가 감시하고 있다면 사각지대 확인
			int s = 0; 
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					if(mapCopy[r][c] == 0) {
						s++; 
					}
				}
			}
//			System.out.println("ans: " + s);
			ans = Integer.min(ans, s); 
			return; 
		}
		
//		System.out.println(cnt);
//		for(int[] i : mapCopy) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println();
		
		// 깊은 복사 
		int[][] temp = new int[N][M];
		for(int r=0; r<N; r++) {		
			for(int c=0; c<M; c++) {
				temp[r][c] = mapCopy[r][c]; 
			}
		}
		
		int curR = cctvs.get(cnt)[1];
		int curC = cctvs.get(cnt)[2];
		
		// 현재 cctv의 범위 정하기
//		System.out.printf("cctvs : %d \n", cctvs.get(cnt)[0]);
		switch(cctvs.get(cnt)[0]) {
		case 1: // 4가지 경우 : 상, 하, 좌, 우
			// 상 
			watch(curR, curC, new int[]{0}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			// 우
			watch(curR, curC, new int[]{1}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			// 하
			watch(curR, curC, new int[]{2}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			// 좌
			watch(curR, curC, new int[]{3}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			
			break; 
		case 2: // 2가지 경우 : 상하, 좌우
			watch(curR, curC, new int[]{0,2}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			watch(curR, curC, new int[]{1,3}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			break; 
		case 3: // 4가지 경우 : 상우, 우하, 하좌, 상좌
			watch(curR, curC, new int[]{0,1}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			
			watch(curR, curC, new int[]{1,2}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			
			watch(curR, curC, new int[]{2,3}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			
			watch(curR, curC, new int[]{3,0}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			break; 
		case 4: // 4가지 경우 : 상우좌013, 우상하102, 하우좌213, 좌상하302
			watch(curR, curC, new int[]{0, 1, 3}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			
			watch(curR, curC, new int[]{1,0,2}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			
			watch(curR, curC, new int[]{2, 1, 3}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			
			watch(curR, curC, new int[]{3, 0, 2}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			break; 
		case 5: // 1가지 경우 : 상하좌우
			watch(curR, curC, new int[]{0, 1, 2, 3}, mapCopy);
			solve(cnt+1, mapCopy); 
			// 원복
			for(int r=0; r<N; r++) {		
				for(int c=0; c<M; c++) {
					mapCopy[r][c] = temp[r][c]; 
				}
			}
			break; 
		}
		
		// 2중 for문으로되돌리기
	}
	
	/**
	 * 
	 * @param r 현재 행 
	 * @param c 현재 열
	 * @param dir 감시 방향
	 */
	static void watch(int r, int c, int[] dir, int[][] mapCopy) {
		// 0 -> #
		for(int d : dir) {
			int nr = r + dr[d]; 
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
			while(mapCopy[nr][nc] != 6) {
				if(mapCopy[nr][nc] == 0) {
					mapCopy[nr][nc] = -1; 					
				}
				
				nr += dr[d]; 
				nc += dc[d]; 
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) break; 
			}
		}
	}
}