import java.io.*; 
import java.util.*; 

public class Main {
	
	static int N, M, dist[][];
	static char map[][]; 
	
	static class Data implements Comparable<Data>{
		int r;
		int c; 
		int w;
		
		public Data(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;			
		}
		
		@Override
		public int compareTo(Data o) {
			return this.w - o.w; 
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		
		map = new char[N][M];
		dist = new int[N][M]; 
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		solve(); 
		
//		for(int[] a : dist) {
//			System.out.println(Arrays.toString(a)); 
//		}
		
		System.out.println(dist[N-1][M-1]); 
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1}; 
	
	static void solve() {
		PriorityQueue<Data> pq = new PriorityQueue(); 
		
		dist[0][0] = 0; 
		pq.offer(new Data(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			
//			System.out.println(cur.r + " " + cur.c + " "+ cur.w);
			
			if(dist[cur.r][cur.c] != cur.w) continue;
			
			for(int d=0; d<4; d++) {
				int nR = cur.r + dr[d];
				int nC = cur.c + dc[d]; 
				
				if(nR < 0 || nC < 0 || nR >= N || nC >= M) continue;
				
				if(dist[nR][nC] <= cur.w + (map[nR][nC] - '0')) continue; 
				
				pq.offer(new Data(nR, nC, cur.w + (map[nR][nC] - '0')));
				dist[nR][nC] = cur.w + (map[nR][nC] - '0');
			}
			
		}
		
	}

}