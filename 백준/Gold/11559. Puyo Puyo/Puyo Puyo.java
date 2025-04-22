import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] map = new char[12][6];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0; i<12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int answer = 0;
		while(true) {
			if(!find()) break;
			fall();
//			print();
			answer++; 
		}
		
		System.out.println(answer);
		
	}
	
	static void fall() {
		Queue<Character> blocks;
		for(int c = 0; c < 6; c++) {
			blocks = new LinkedList<>();
			for(int r=11; r>=0; r--) {
				if(map[r][c] == '.') continue;
				blocks.add(map[r][c]);
				map[r][c] = '.';
			}
			
			int idx = 11;
			while(!blocks.isEmpty()) {
				map[idx--][c] = blocks.poll();
			}
		}
	}
	
	static int[] dr = {-1, 1, 0, 0}; 
	static int[] dc = {0, 0, -1, 1};
	static boolean find() {
		boolean res = false;
		for(int r = 11; r>=0; r--) {
			for(int c=0; c<6; c++) {
				if(map[r][c] == '.') continue;
				bfs(r, c, map[r][c]);
				
				if(removal.size() >= 4) {
					for(int[] cur : removal) {
						map[cur[0]][cur[1]] = '.';
					}
//					print(); 
					removal.clear();
					res = true;
				}else {
					removal.clear();
				}
			}
		}
		return res;
	}
	
	static List<int[]> removal = new ArrayList<>();
	static void bfs(int sr, int sc, char type) {
		boolean[][] v = new boolean[12][6];
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {sr, sc});
		v[sr][sc] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			removal.add(cur);
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= 12 || nc >= 6) continue;
				if(v[nr][nc]) continue;
				if(map[nr][nc] != type) continue;
				
				v[nr][nc] = true; 
				q.offer(new int[] {nr, nc});
			}
		}
	}

	static void print() {
		for(int i=0; i<12; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
}