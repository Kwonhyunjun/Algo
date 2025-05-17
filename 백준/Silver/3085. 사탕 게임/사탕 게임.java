import java.io.*;
import java.util.*;

public class Main {

	static int N, answer;
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) { 
			map[i] = br.readLine().toCharArray();
		}
		
		check();
		
		int[] dr = {1, 0};
		int[] dc = {0, 1};
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int d=0; d<2; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr >= N || nc >= N) continue;
					if(map[i][j] == map[nr][nc]) continue;
					change(i, j, nr, nc);
					check();
					change(i, j, nr, nc);
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	static void change(int i, int j, int nr, int nc) {
		char temp = map[i][j];
		map[i][j] = map[nr][nc];
		map[nr][nc] = temp;
	}
	
	static void check() {
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			// 행
			char prev = map[i][0];
			int temp = 1;
			for(int j=1; j<N; j++) {
				if(map[i][j] == prev) {
					temp++;
					cnt = Math.max(cnt, temp);
				}else {
					prev = map[i][j];
					temp =1;
				}
			}
			
			cnt = Math.max(cnt, temp);
			
			// 열
			prev = map[0][i];
			temp = 1;
			for(int j=1; j<N; j++) {
				if(map[j][i] == prev) {
					temp++;
					cnt = Math.max(cnt, temp);
				}else {
					prev = map[j][i];
					temp = 1;
				}
			}
			
			cnt = Math.max(cnt, temp);
		}
		
		answer = Math.max(answer, cnt);
	}

}