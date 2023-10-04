import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; 
	static char[][] map; 
	static boolean[][][] v; 
	static int ans; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		v = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray(); 
		}
		// Input End
		
		ans = -1; 
		bfs(); 
		System.out.println(ans);
	}

	static int[] dr = {-1, 0, 1, 0}; 
	static int[] dc = {0, 1, 0, -1}; 
	
	private static void bfs() {
//		List<int[]> list = new ArrayList<>();  
//		
//		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// TODO Auto-generated method stub
//				return -(o1[2]-o2[2]);
//			}
//		});
		Queue<int[]> q = new ArrayDeque<>(); 
		
		q.offer(new int[]{0, 0, 1});
		v[0][0][1] = true; 
		
		int time = 1;
		int size; 
		while(!q.isEmpty()) {
			size = q.size(); 
			
			for(int i=0; i<size; i++) {
				int[] cur = q.poll(); 
				int broke = cur[2]; 
				int idx = broke==1 ? 1 : 0; 
				
				if(cur[0] == N-1 && cur[1] == M-1) {
					ans = time; 
					return; 
				}
				
				for(int d=0; d<4; d++) {
					int nr = cur[0] +dr[d]; 
					int nc = cur[1] +dc[d]; 
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					
					// 벽 여부 
					if(map[nr][nc] == '1') {
						if(v[nr][nc][idx]) continue; 
						if(broke == 0) {
							continue; 
						}else {
							q.offer(new int[] {nr, nc, broke-1}); 
							v[nr][nc][idx] = true; 
						}
					}else { 
						if(v[nr][nc][idx]) continue; 
						q.offer(new int[] {nr, nc, broke}); 
						v[nr][nc][idx] = true; 
					}
				}
				
			}
			time++; 
		}
	}


}