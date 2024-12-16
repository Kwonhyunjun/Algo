import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, start[], buildingCnt, attack[][];
	static char[][] map;
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		start = new int[2];
		map = new char[N][M];
		attack = new int[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == '.' || map[i][j] == '|') continue; 
				if(map[i][j] == '@') {
					start[0] = i; start[1] = j; 
				}else {
					buildingCnt++;
				}
				
			}
		}
		
		firstWave(start[0], start[1]);
		
		int broken = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'X') broken++;
			}
		}
		
		
		System.out.println(broken + " " + (buildingCnt - broken));

	}

	static void firstWave(int r, int c) {
		for(int d=0; d<4; d++) {
//			System.out.println(d);
			for(int i=1; i<=2; i++) {
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;
//				System.out.println(nr + " " + nc);
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;
				if(map[nr][nc] == '|') break;

				
				if(map[nr][nc] == '#') {
					map[nr][nc] = '*'; 
					continue;
				}
				
				if(map[nr][nc] == '*') {
					map[nr][nc] = 'X';
					secondWave(nr, nc);
				}
			}
//			print();
		}
	}
	
	

	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static void secondWave(int r, int c) {
		
//		System.out.println("second" + " " + r + " " + c);
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			
			if(map[nr][nc] == '|') continue;
			
			if(map[nr][nc] == '#') {
				map[nr][nc] = '*'; 
				continue;
			}
			
			if(map[nr][nc] == '*') {
				map[nr][nc] = 'X';
				secondWave(nr, nc);
			}
		}
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}