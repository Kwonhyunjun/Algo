import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution { 
	static int N; 
	static int[][] map; 
	static int ans; 
	static int sr, sc, er, ec; 
	static StringBuilder sb = new StringBuilder(); 
	
	static class Data{
		int r; 
		int c; 
		int cnt;
		
		public Data(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Data [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N]; 
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			// Input End
			
			bfs();
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1}; 
	private static void bfs() {
		boolean[][] v = new boolean[N][N]; 
		
		PriorityQueue<Data> pq = new PriorityQueue<Data>(new Comparator<Data>() {

			@Override
			public int compare(Solution.Data o1, Solution.Data o2) {
				return o1.cnt - o2.cnt;
			}
		});
		
		// 시작점
		pq.offer(new Data(sr, sc, 0));
		v[sr][sc] = true; 
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll(); 
//			System.out.println(cur);
			int r = cur.r;
			int c = cur.c;
			
			if(er == r && ec == c) {
				ans = cur.cnt;
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 범위체크 
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
				// 방문체크 
				if(v[nr][nc]) continue; 
				// 시뮬레이션 - 벽
				if(map[nr][nc] == 1) continue; 
				// 시뮬레이션 - 파도
				if(map[nr][nc] == 2) {
					int time = 3 * (cur.cnt/3) + 3; 
					pq.offer(new Data(nr, nc, time)); 
//					System.out.println(nr + " " + nc +" "+time); 
					v[nr][nc] = true;
				}else {
					pq.offer(new Data(nr,nc,cur.cnt+1)); 
//					System.out.println(nr + " " + nc +" "+ cur.cnt+1); 
					v[nr][nc] = true; 
				}
			}
		}
		ans = -1; 
	}


}