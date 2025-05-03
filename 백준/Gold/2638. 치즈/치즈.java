import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, map[][], cheeseCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheeseCnt++;
			}
		}
		
		System.out.println(solve());
		
	}
	
	static int solve() {
		int time = 0;
		
		while(true) {
			
//			print();
			// 녹을 치즈 확인
			meltCheese = new ArrayList<>();
			check();
			
			// 치즈 녹임
			for(int[] n : meltCheese) {
				map[n[0]][n[1]] = 0;
			}
			cheeseCnt -= meltCheese.size();
			
//			print();
			
//			if(time == 0) break;
			time++;
			if(cheeseCnt == 0) break;
			
		}
		
		return time;
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static List<int[]> meltCheese; 
	
	static void check() {
		boolean[][] v = new boolean[N][M];
		int[][] cnt = new int[N][M];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		v[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.printf("cur -> %d %d\n", cur[0], cur[1]); 
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(map[nr][nc] == 1) {
					if(cnt[nr][nc] != -1) {
						cnt[nr][nc]++; 
//						System.out.printf("cur[%d][%d] -> cnt[%d][%d]++ : %d\n", cur[0], cur[1], nr, nc, cnt[nr][nc]);
						if(cnt[nr][nc] > 1) {
//							System.out.printf("cur[%d][%d] -> meltCheese.add(new int[]{%d, %d}\n", cur[0], cur[1], nr, nc);
							meltCheese.add(new int[] {nr, nc});
							cnt[nr][nc] = -1;
						}
					}
					continue;
				}
				
				if(v[nr][nc]) continue;
				v[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}