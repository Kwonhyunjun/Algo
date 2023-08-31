import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


// 나이트의 이동
public class Main {
	static int N;
	static int[][] v;
	static int sr, sc, er, ec; 
	static int ans; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine()); 
		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine()); 
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			v = new int[N][N]; 
			
			// 시작 
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			
			// 끝 
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			ans = 0 ; 
			bfs(sr, sc); 
			System.out.println(v[er][ec]-1);
			
		}
	}
	
	static int[] dr = {-2, -2, -1, 1, 2, 2, -1, 1}; 
	static int[] dc = {-1, 1, 2, 2, -1, 1, -2, -2}; 
	
	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque(); 
	
		q.offer(new int[] {sr, sc}); 
		int cnt = 1; 
		v[sr][sc] = cnt;
		
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++; 
			
			for(int i = 0 ; i< size; i++) {
				int[] cur = q.poll(); 
				
				if(cur[0] == er && cur[1] == ec) {
					return; 
				}
				
				for(int d = 0; d < 8 ; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; // 범위 넘어가면 continue
					if(v[nr][nc] != 0) continue; // 방문 확인
					
					q.offer(new int[] {nr, nc}); 
					v[nr][nc] = cnt; // 방문 체크 
					
				}
			}
		}
	}

}
