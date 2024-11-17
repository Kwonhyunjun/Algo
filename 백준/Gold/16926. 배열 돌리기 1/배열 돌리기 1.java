import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, M, R, map[][];
	static boolean[][] v; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		for(int i=0; i<R; i++) {
			v = new boolean[N][M];
			rotate(); 
		}
		
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n"); 
		}
		
		System.out.println(sb);
		

	}
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static void rotate() {
		for(int i=0; i<Math.min(N, M); i++) {
			
			int d = 0; 
			int prev = map[i][i];
//			System.out.printf("시작점 : map[%d][%d] = %d\n", i, i, prev);
			
			int nr = i; 
			int nc = i; 
			
			while(!(nr == i && nc == i && v[i][i])) {
				nr += dr[d];
				nc += dc[d];
				
				if((nr < 0 || nc < 0 || nr >= N || nc >= M) ||  v[nr][nc]) {
					nr -= dr[d];
					nc -= dc[d];
					d = (d+1) % 4;
					continue; 
				}
//				System.out.printf("%d %d \n", nr, nc); 
				
				int temp = map[nr][nc];
				map[nr][nc] = prev;
				prev = temp; 
				v[nr][nc] = true;
				
			}
			
			// 회전 출력
//			for(int j=0; j<N; j++) {
//				System.out.println(Arrays.toString(map[j])); 
//			}
//			System.out.println();
		}
	}

}