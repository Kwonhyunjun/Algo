import java.io.*;
import java.util.*;

public class Main {
	
	static int N, map[][], answer; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); 
		map = new int[N][N]; 
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		answer = Integer.MAX_VALUE;
		int left = 0; 
		int right = (max - min); 
		
		
		while(left <= right) {
			int mid = left + (right - left) / 2; 
			
			if(isPossible(mid)) {
				answer = Math.min(mid, answer);
				right = mid - 1; 
			}else {
				left = mid + 1; 
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1}; 
	
	static boolean isPossible(int mid) {
		boolean[][] v = new boolean[N][N];
		
		Queue<int[]> q = new ArrayDeque<>(); 
		q.offer(new int[] {0, 0, map[0][0]});
		v[0][0] = true; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll(); 
			
			if(cur[0] == N-1 && cur[1] == N-1) return true; 
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
				if(v[nr][nc]) continue;
				if(Math.abs(cur[2] - map[nr][nc]) > mid) continue;
				
				q.offer(new int[] {nr, nc, map[nr][nc]});
				v[nr][nc] = true; 
				
			}
		}
		
		return false; 
		
	}

}