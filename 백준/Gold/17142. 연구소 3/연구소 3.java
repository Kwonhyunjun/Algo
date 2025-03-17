import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, map[][], answer, choosen[];
	static List<int[]> virus = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new int[] {i, j});
			}
		}
		if(check(map)) {
			answer = 0; 
		}else {
			choosen = new int[M];
			answer = Integer.MAX_VALUE;
			choose(0, 0);			
		}
		
		System.out.println((answer== Integer.MAX_VALUE) ? -1 : answer);

	}
	
	// 활성화 시킬 바이러스 선택하는 메서드
	static void choose(int idx, int start) {
		if(idx == M) {			
			int res = spread();
//			System.out.println(Arrays.toString(choosen));
//			System.out.println(res);
			if(res != -1) {
				answer = Math.min(answer, res);
			}
			
			return; 
		}
		
		for(int i=start; i<virus.size() ; i++) {
			choosen[idx] = i;
			choose(idx+1, i+1);
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1}; 
	
	// 바이러스 퍼뜨리기
	static int spread() {
		// 맵 복사
		int[][] temp = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		boolean[][] v = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int idx : choosen) {
			int[] active = virus.get(idx);
			int sr = active[0];
			int sc = active[1];
			v[sr][sc] = true;
			q.offer(new int[] {sr, sc});
			temp[sr][sc] = 3;
		}
		
		int time = 0; 
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				int[] cur = q.poll();
				
				for(int d=0; d<4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					if(temp[nr][nc] == 1) continue;
					if(v[nr][nc]) continue;
					
					v[nr][nc] = true;
					q.offer(new int[]{nr, nc});
					temp[nr][nc] = 3; 
				}
			}
			
			time++;
		
			if(check(temp)) return time; 
//			System.out.println("time : " + time);
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
		}
		
		
		
		if(!check(temp)) return -1; 
		
		return time; 
	}
	
	
	// 모든 빈칸에 바이러스를 퍼뜨렸는지 체크하는 메서드
	static boolean check(int[][] temp) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(temp[i][j] == 0) return false;
			}
		}
		return true;
	}

}