import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, ans;
	static char[][] map; 
	static boolean[][][] v;
	
	static class Data implements Comparable<Data>{
		int r; 
		int c; 
		int d; 
		int cnt;
		
		public Data(int r, int c, int d, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Main.Data o) {
			// TODO Auto-generated method stub
			return this.d-o.d;
		}
		
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		v = new boolean[N][M][11];
		
		for(int r=0; r<N; r++) {
			map[r] = br.readLine().toCharArray(); 
		}
		ans = -1; 
		bfs();
		System.out.println(ans);
	}
	
	static int[] dr = {-1, 0, 1, 0}; 
	static int[] dc = {0, -1, 0, 1}; 

	static void bfs() {
		PriorityQueue<Data> q = new PriorityQueue<>(); 
		
		q.offer(new Data(0, 0, 0, 0)); 
		v[0][0][0] = true; 
		
		while(!q.isEmpty()) {
			Data cur = q.poll(); 
			if(cur.r == N-1 && cur.c == M-1) {
				ans = cur.d+1; 
				return;
			}
			
			for(int d =0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >=N || nc >= M) continue; 
				
				if(map[nr][nc] == '0') { // 벽이 아닐 경우
					if(v[nr][nc][cur.cnt]) continue; // 방문체크
					
					q.offer(new Data(nr, nc, cur.d +1, cur.cnt)); 
					v[nr][nc][cur.cnt] = true;
					
				}else {
					if(cur.cnt >= K) continue; // 벽 다 부숨
					if(v[nr][nc][cur.cnt +1]) continue; // 방문체크
					
					q.offer(new Data(nr, nc, cur.d +1, cur.cnt+1)); 
					v[nr][nc][cur.cnt +1] = true;
				}
			}
		}
	}
}