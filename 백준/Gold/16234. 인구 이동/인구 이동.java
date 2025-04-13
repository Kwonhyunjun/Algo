import java.io.*;
import java.util.*;

public class Main {

	static int N, L, R, people[][];
	static boolean[][] v, border[];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1}; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		people = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		while(true) {
			// 국경선 열기
			if(!openBorder()) break;
			
			// 인구 인동
			movePeople();
			
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(people[i]));
//			}
			
			answer++; 
		}
		
		System.out.println(answer); 
		
	}
	
	static boolean openBorder() { 
		boolean isOpen = false;
		border = new boolean[N][N][4];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				for(int d=0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					int diff = Math.abs(people[nr][nc] - people[r][c]);
					if(diff >= L && diff <= R) {
						isOpen = true;
						border[r][c][d] = true;
					}
				}
			}
		}
		
		return isOpen;
	}
	
	static void movePeople() {
		v = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(v[r][c]) continue;
				v[r][c] = true;
				bfs(r, c);
			}
		}
	}
	
	static void bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> traces = new ArrayList<>();
		q.offer(new int[] {sr, sc});
		
		int total = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			traces.add(new int[] {cur[0], cur[1]});
			
			cnt++;
			total += people[cur[0]][cur[1]];
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(v[nr][nc]) continue;
				if(!border[cur[0]][cur[1]][d]) continue;
				
				q.offer(new int[] {nr, nc});
				v[nr][nc] = true;
			}
			
			int divde = total / cnt;
			for(int[] trace : traces) {
				people[trace[0]][trace[1]] = divde;
			}
		}
	}

}