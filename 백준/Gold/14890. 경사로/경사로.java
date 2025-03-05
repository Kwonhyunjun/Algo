import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, M, map[][]; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			if(checkRowRoute(i)) {
//				System.out.println(i);
				answer++;
			}
		}
		
//		System.out.println("----");
		
		for(int i=0; i<N; i++) {
			if(checkColumnRoute(i)) {
//				System.out.println(i);
				answer++;
			}
		}
		
		System.out.println(answer);

	}
	
	static boolean[] ladder;
	static boolean checkRowRoute(int i) {
		ladder = new boolean[N];
		
		for(int j=1; j<N; j++) {
			// 끝까지 도달했으면 true 반환 
			
			
			// 현재 높이와 갈 높이 비교
			int cur = map[i][j-1];
			int next = map[i][j]; 
			int diff = cur - next;
			
			if(diff == 0) continue; // 만약 경사가 없다면 직진
			if(Math.abs(diff) > 1) return false; // 만약 경사도가 1이상 차이나면 false 반환
			
			if(diff < 0) {
				// 더 높은 곳으로
				if(!canPutLadder(i, j-1, cur, -1, true)) return false;; 
			}else {
				// 더 낮은 곳으로 
				if(!canPutLadder(i, j, next, 1, true)) return false;
			}
			cur = map[i][j];
		}
		
		return true;
	}
	
	static boolean canPutLadder(int i, int curPos ,int curHeight, int dir, boolean isRow) {
		
		for(int l=0; l<M; l++) {
			int ladderIdx = curPos + (dir * l);
			// 사다리 놓을 자리가 범위에 벗어나면 false 반환
			if(ladderIdx < 0 || ladderIdx >= N) return false;
			// 이미 사다리가 있다면 false 반환
			if(ladder[ladderIdx]) return false;
			// 사다리 놓을 곳의 땅이 고르지 못하면 false 반환
			
			if(isRow) {
				if(map[i][ladderIdx] != curHeight) return false;
			}else {
				if(map[ladderIdx][i] != curHeight) return false;
			}
			
		}
		
		// 사다리 놓기
		for(int l=0; l<M; l++) {
			int ladderIdx = curPos + (dir * l);
			ladder[ladderIdx] = true;
		}
		
		return true;
	}

	
	static boolean checkColumnRoute(int i) {
		ladder = new boolean[N];
		
		for(int j=1; j<N; j++) {
			// 끝까지 도달했으면 true 반환 
			
			
			// 현재 높이와 갈 높이 비교
			int cur = map[j-1][i];
			int next = map[j][i]; 
			int diff = cur - next;
			
			if(diff == 0) continue; // 만약 경사가 없다면 직진
			if(Math.abs(diff) > 1) return false; // 만약 경사도가 1이상 차이나면 false 반환
			
			if(diff < 0) {
				// 더 높은 곳으로
				if(!canPutLadder(i, j-1, cur, -1, false)) return false;; 
			}else {
				// 더 낮은 곳으로 
				if(!canPutLadder(i, j, next, 1, false)) return false;
			}
			cur = map[i][j];
		}
		
		return true;
	}
	
}