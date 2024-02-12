import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt, stat, map[][], temp[][]; 
	static ArrayDeque<int[]> deq; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		stat = -1; // -1(가로), -2(세로), -3(대각선)
		
		deq = new ArrayDeque<>();
		deq.offer(new int[] {0,0});
		deq.offer(new int[] {0,1});
	
		move(0, 1, -1); 
		
		System.out.println(cnt);
	}
	
	
	
	private static void move(int curR, int curC, int stat) {
		
		if(curR == N-1 && curC == N-1) { 
			cnt++; 
			return; 
		}
		
		// 현재 상태에 따라 
		if(stat == -1) {
			// 1. 가로 -> 가로
			if(curC+1 < N &&
					map[curR][curC+1] != 1) {
				deq.offer(new int[]{curR, curC+1});
				move(curR, curC+1, -1);
			}
			
			
			// 2. 가로 -> 대각선
			if(curR+1 < N && curC+1 < N &&
					map[curR+1][curC+1] != 1 &&
					map[curR][curC+1] != 1 &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC+1});
				stat = -3; 
				move(curR+1, curC+1, -3);
			}
			
			
		}else if(stat == -2) {
			// 1. 세로 -> 세로
			if(curR+1 < N &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC});
				move(curR+1, curC, -2);
			}
			
			// 2. 세로 -> 대각선
			if(curR+1 < N && curC+1 < N &&
					map[curR+1][curC+1] != 1 &&
					map[curR][curC+1] != 1 &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC+1});
				stat = -3; 
				move(curR+1, curC+1, -3);
			}
			
		}else {
			// 1. 대각선 -> 가로
			if(curC+1 < N &&
					map[curR][curC+1] != 1) {
				deq.offer(new int[]{curR, curC+1});
				stat = -1; 
				move(curR, curC+1, -1);
			}
			
			// 2. 대각선 -> 세로
			if(curR+1 < N &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC});
				stat = -2; 
				move(curR+1, curC, -2);
			}
			
			// 3. 대각선 -> 대각선
			if(curR+1 < N && curC+1 < N &&
					map[curR+1][curC+1] != 1 &&
					map[curR][curC+1] != 1 &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC+1});
				move(curR+1, curC+1, -3);
			}
		}
		
	}



	static void move() {
		int[] prev = deq.poll(); // 00 
		
		int curR = deq.peek()[0]; // 01 
		int curC = deq.peek()[1];
		
//		temp = new int[N][N]; 
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				temp[i][j] = map[i][j];
//			}
//		}
//		
//		temp[prev[0]][prev[1]] = -1; 
//		temp[curR][curC] = -1; 
//		System.out.println();
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(temp[i]));
//		}
//		System.out.printf("[%d, %d], [%d, %d]\n", prev[0], prev[1], curR, curC);
//		
		// 도착점에 도달했다면 
		if(curR == N-1 && curC == N-1) { 
			cnt++; 
			return; 
		}
		
		
		// 현재 상태에 따라 
		if(stat == -1) {
			// 1. 가로 -> 가로
			if(curC+1 < N &&
					map[curR][curC+1] != 1) {
				deq.offer(new int[]{curR, curC+1});
				move();
				// 원복 (prev를 앞에 놓고 방금 넣었던걸 뺌)
				deq.poll(); 
				deq.offer(prev);
				deq.offer(new int[] {curR, curC}); 
				
				for(int[] i : deq) {
					System.out.println(i[0]+" "+ i[1]);
				}
			}
			
			
			// 2. 가로 -> 대각선
			if(curR+1 < N && curC+1 < N &&
					map[curR+1][curC+1] != 1 &&
					map[curR][curC+1] != 1 &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC+1});
				stat = -3; 
				move();
				// 원복 (prev를 앞에 놓고 방금 넣었던걸 뺌)
				deq.poll(); 
				deq.offer(prev);
				deq.offer(new int[] {curR, curC}); 

			}
			
			
		}else if(stat == -2) {
			// 1. 세로 -> 세로
			if(curR+1 < N &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC});
				move();
				// 원복 (prev를 앞에 놓고 방금 넣었던걸 뺌)
				deq.poll(); 
				deq.offer(prev);
				deq.offer(new int[] {curR, curC}); 
			}
			
			// 2. 세로 -> 대각선
			if(curR+1 < N && curC+1 < N &&
					map[curR+1][curC+1] != 1 &&
					map[curR][curC+1] != 1 &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC+1});
				stat = -3; 
				move();
				// 원복 (prev를 앞에 놓고 방금 넣었던걸 뺌)
				deq.poll(); 
				deq.offer(prev);
				deq.offer(new int[] {curR, curC}); 
			}
		}else {
			// 1. 대각선 -> 가로
			if(curC+1 < N &&
					map[curR][curC+1] != 1) {
				deq.offer(new int[]{curR, curC+1});
				stat = -1; 
				move();
				// 원복 (prev를 앞에 놓고 방금 넣었던걸 뺌)
				deq.poll(); 
				deq.offer(prev);
				deq.offer(new int[] {curR, curC}); 
			}
			
			// 2. 대각선 -> 세로
			if(curR+1 < N &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC});
				stat = -2; 
				move();
				// 원복 (prev를 앞에 놓고 방금 넣었던걸 뺌)
				deq.poll(); 
				deq.offer(prev);
				deq.offer(new int[] {curR, curC}); 
			}
			
			// 3. 대각선 -> 대각선
			if(curR+1 < N && curC+1 < N &&
					map[curR+1][curC+1] != 1 &&
					map[curR][curC+1] != 1 &&
					map[curR+1][curC] != 1) {
				deq.offer(new int[]{curR+1, curC+1});
				move();
				// 원복 (prev를 앞에 놓고 방금 넣었던걸 뺌)
				deq.poll(); 
				deq.offer(prev);
				deq.offer(new int[] {curR, curC}); 
			}
		}
		
		
	}

}