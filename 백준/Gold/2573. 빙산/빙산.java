import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
	
	public class Main {
		static int N, M, map[][], ans; 
		static List<Integer> list; 
		static boolean isSeparated;
		static boolean[][] v; 
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			 
			map = new int[N][M]; 
			list = new ArrayList<>();
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine()); 
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					if(map[r][c] != 0) {
						list.add(r*M + c); 
					}
				}
			}
			
			int year = 0; 
			while(true) {
				// 이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구하는 프로그램
				
				// 빙산의 개수 -> 개수가 2개 이상이면 break; 
				if(check()) {
					ans = year; 
					break; 
				}; 
				//
				melt(); // 녹임
				if(list.size() == 0) {
					ans = 0; 
					break; 
				}
				year++; 
			}
			System.out.println(ans);
		}
		private static boolean check() {
			v = new boolean[N][M]; 
			int cnt = 0; // 섬의 개수 파악 
			
			for(int i=0; i<list.size(); i++) {
				int n = list.get(i); 
				if(v[n/M][n%M]) continue; // 이미 방문한 곳이라면 넘어감
				bfs(n); 
				cnt++;
				if(cnt >= 2) {
					return true; 
				}
			}
//			System.out.println("cnt : " + cnt);
			return false; 
		}
		
		private static void bfs(int start) {
			Queue<int[]> q = new ArrayDeque<int[]>();
			q.offer(new int[] {start/M, start%M}); 
			v[start/M][start%M] = true; 
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				for(int d=0; d<4; d++) {
					int nr = cur[0] + dr[d]; 
					int nc = cur[1] + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(v[nr][nc]) continue; 
					if(map[nr][nc] == 0) continue; 
					
					q.offer(new int[] {nr, nc});
					v[nr][nc] = true; 
				}
			}
		}
	
		static int[] dr = {-1, 0, 1, 0}; 
		static int[] dc = {0, 1, 0, -1}; 
		// 빙산 녹이기
		static void melt() {
			// 배열 복사
			int[][] temp = new int[N][M]; 
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					temp[r][c] = map[r][c]; 
				}
			}
			
			for(int i = list.size()-1; i >= 0 ; i--) {
				int curR = list.get(i) / M; 
				int curC = list.get(i) % M; 
				
				int cnt = 0; 
				// 방향 확인하면서 바다물인지 확인
				for(int d=0; d<4; d++) {
					int nr = curR + dr[d]; 
					int nc = curC + dc[d]; 
					
					// 범위 벗어남
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					if(map[nr][nc] == 0) cnt++; 
				}
	//			System.out.printf("map[%d][%d] : %d - %d\n", curR, curC, map[curR][curC], cnt);
				temp[curR][curC] = (map[curR][curC] - cnt < 0)? 0 : map[curR][curC] - cnt ; 
				if(temp[curR][curC] == 0) list.remove(i);
			}
			map = temp; 
	//		System.out.println();
//			for(int[] arr : map) {
//				System.out.println(Arrays.toString(arr));
//			}
	//		System.out.println(list);
		}
		
	}