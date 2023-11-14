import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], ans;
	static int[] robot = new int[3]; 
	
	static int[] dr = {-1, 0, 1, 0}; 
	static int[] dc = {0, 1, 0, -1}; 
	

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) {
			robot[i] = Integer.parseInt(st.nextToken()); 
		}
		
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine()); 
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken()); 
			}
		}
		// Input End
		solve();
		System.out.println(ans);
		                                                                                                                                                                                                       
	}

	static void solve() {
		
		int r = robot[0]; 
		int c = robot[1]; 
		int dir = 0; 
		while(true) {
			dir = robot[2]; 
//			System.out.println(1);
			// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(map[r][c] == 0) {
				map[r][c] = 2; 
				ans++; 
			}
			
			// 4칸 중 청소되지 않은 빈 칸이 없는 경우
			boolean chk = false; 
			for(int d=0; d<4; d++) {
				int nr = r + dr[d]; 
				int nc = c + dc[d]; 
				
				if( nr < 0 || nc < 0 || nr >= N || nc >= M) continue; 
				if(map[nr][nc] == 0) { // 청소되지 않은 빈칸
					chk = true;
				}
			}
			
			if(!chk) { // 빈칸이 없는 경우 
				// 바라보는 방향을 유지한 채로 한칸 후진 
				// 상(0) <-> 하(2)
				// 좌(1) <-> 우(3) 
				int nr = 0; 
				int nc = 0; 
				switch(dir) {
				case 0 : 
					nr = r + dr[2]; 
					nc = c + dc[2]; 
					break;
				case 1 : 
					nr = r + dr[3]; 
					nc = c + dc[3]; 
					break;
				case 2 : 
					nr = r + dr[0]; 
					nc = c + dc[0]; 
					break;
				case 3 : 
					nr = r + dr[1]; 
					nc = c + dc[1]; 
					break;
				}
				
				// 후진할 수 없다면 작동 멈춤
				if(map[nr][nc] == 1) {
					return; 
				}else {
					r = nr; 
					c = nc; 
				}
				
			}else {
				// 반시계 방향으로 90도 회전
				int nr = 0; 
				int nc = 0; 
				for(int i=0; i<4; i++) {
//					System.out.println(2);
					switch(dir) {
					case 0 : 
						robot[2] = 3; 
						nr = r + dr[3]; 
						nc = c + dc[3]; 
						break;
					case 1 : 
						robot[2] = 0; 
						nr = r + dr[0]; 
						nc = c + dc[0]; 
						break;
					case 2 : 
						robot[2] = 1; 
						nr = r + dr[1]; 
						nc = c + dc[1]; 
						break;
					case 3 : 
						robot[2] = 2; 
						nr = r + dr[2]; 
						nc = c + dc[2]; 
						break;
					}
					// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈칸인 경우 한칸 전진
					if(map[nr][nc] == 0 ) {
						r = nr; 
						c = nc; 
						break; 
					}
				}
				
				
			}
		}
		
		
		
	}
}