import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static char map[][];
	static ArrayList<int[]> teacher = new ArrayList<>(); 
	static boolean canHide = false; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') teacher.add(new int[] {i, j});
			}
		}
		
		
		build(0, 0, new ArrayList<>());
		
		
		String answer = canHide ? "YES" : "NO";
		
		System.out.println(answer);
	}
	
	static void build(int cnt, int start, ArrayList<Integer> position) {
		if(canHide) return; 
		
		if(cnt == 3) {
//			System.out.println(position);
			
			for(int p : position) {
				map[p/N][p%N] = 'O';
			}
			
			canHide = observe();
			
			for(int p : position) {
				map[p/N][p%N] = 'X';
			}
			
			return; 
		}
		
		for(int i=start; i<N*N; i++) {
			int r = i / N;
			int c = i % N; 
			
			if(map[r][c] == 'X') {
				position.add(i); 
				build(cnt+1, i+1, position);
				position.remove(position.size()-1);
			}
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1}; 
	
	static boolean observe() {
		
		for(int[] cur : teacher) {
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				while(true) {
//					System.out.println(nr + " " + nc);
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) break; 
					if(map[nr][nc] == 'O') break;
					
					if(map[nr][nc] == 'S') return false;
					
					nr += dr[d];
					nc += dc[d];
				}
			}
			
		}
		
		return true; 
	}
}