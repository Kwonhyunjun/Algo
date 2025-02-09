import java.io.*;
import java.util.*;

public class Main {

	static int N, map[][], answer;
	static Shark shark; 
	
	static class Shark{
		int r, c, size, eat;
		
		public Shark(int r, int c) {
			this.r = r; 
			this.c = c;
			this.size = 2; 
			this.eat = 0; 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) shark = new Shark(i, j);
			}
		}
		
		
		solve();
		System.out.println(answer);

	}
	
	static void solve() {
		
		while(true) {
//			System.out.printf("위칠 : %d %d, 사이즈 :  %d, 먹은 물고기 수 %d\n",shark.r, shark.c, shark.size, shark.eat);
			int[] catchFish = findFish(shark.r, shark.c);
			
//			System.out.printf("위치 : %d %d, 사이즈 :  %d, 먹은 물고기 수 %d\n",shark.r, shark.c, shark.size, shark.eat);
//			System.out.println(Arrays.toString(catchFish));
			
			if(catchFish[0] == -1) {
				return;
			}else {
				// 상어 이동
				map[shark.r][shark.c] = 0;
				shark.r = catchFish[0];
				shark.c = catchFish[1];
				
				// 물고기 처리
				map[catchFish[0]][catchFish[1]] = 0; 
				shark.eat++; 
				
				// 물고기 크기 처리
				if(shark.size == shark.eat) {
					shark.size++; 
					shark.eat = 0; 
				}
				
				// 이동거리 처리
				answer += catchFish[2];
			}
		}
	}
	
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, -1, 0, 1};
	static int[] findFish(int sr, int sc) {
		
//		System.out.println("------------------------------findFish----------------------------------");
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][N];
		
		q.offer(new int[] {sr, sc, 0});
		v[sr][sc] = true;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			int[] candidate = new int[] {N, N, N};
			
			for(int i=0; i<size; i++) {
				int[] cur = q.poll();
//				System.out.println(Arrays.toString(cur));
				
				if(map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < shark.size) {
					if((candidate[0] > cur[0]) || (candidate[0] == cur[0] && candidate[1] > cur[1])) {
						
						candidate[0] = cur[0];
						candidate[1] = cur[1];
						candidate[2] = cur[2];
					} 
				}
				
				for(int d=0; d<4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					if(v[nr][nc]) continue;
					if(map[nr][nc] > shark.size) continue;
					
					q.offer(new int[] {nr, nc, cur[2]+1});
					v[nr][nc] = true;
				}
			}
			
			if(candidate[0] != N) return candidate;
		}
		
		return new int[] {-1, -1, -1};
	}

}