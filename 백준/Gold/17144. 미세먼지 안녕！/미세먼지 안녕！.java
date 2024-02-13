import java.io.*;
import java.util.*;

public class Main {

	static int R, C, T, map[][], temp[][];
	static List<int[]> purifier; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		T = Integer.parseInt(st.nextToken()); // 시간
		
		map = new int[R][C];
		purifier = new ArrayList<>(); 
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) purifier.add(new int[]{i, j}); 
			}
		}
		
		for(int t=0; t<T; t++) {
			// 확산
			spread();
//			System.out.println("확산");
//			for(int i=0; i<R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			// 순환 1
			int[] start = purifier.get(0);
			int curR = start[0]+dr[0]; int curC = start[1]+dc[0]; 
			int d = 0; 
			
//			System.out.printf("curR : %d, curC : %d\n", curR, curC);
			
			while(true) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
//				System.out.printf("nr : %d, nc : %d\n", nr, nc);
				
				if(nr < 0 || nr > start[0] || nc < 0 || nc >= C) {
					d = (d+1)%4;
//					System.out.printf("방향전환 %d\n", d);
					continue; 
				}
//				System.out.printf("통과 nr : %d, nc : %d\n", nr, nc);
				
				if(map[nr][nc] == -1) {
					map[curR][curC] = 0;
					break;
				}else {
					map[curR][curC] = map[nr][nc];
					curR = nr; 
					curC = nc;
				} 
			}
//			System.out.println("첫번쨰 순환");
//			for(int i=0; i<R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			
			// 순환 2
			start = purifier.get(1);
			curR = start[0]+dr[2]; curC = start[1]+dc[2];
			while(true) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				if(nr < start[0] || nr >= R || nc < 0 || nc >= C) {
					d = (d-1) < 0 ? 3 : d-1;
//					System.out.printf("방향전환 %d\n", d);
					continue; 
				}

//				System.out.printf("통과 nr : %d, nc : %d\n", nr, nc);
				
				if(map[nr][nc] == -1) {
					map[curR][curC] = 0;
					break;
				}else {
					map[curR][curC] = map[nr][nc];
					curR = nr; 
					curC = nc;
				} 
			}
//			System.out.println("두번쨰 순환");
//			for(int i=0; i<R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
		}
		
		// 출력
		int sum = 0; 
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sum += map[i][j]; 
			}
		}
		System.out.println(sum+2);
	}
	
	static int[] dr = {-1, 0, 1, 0};  // 상 우 하 좌
	static int[] dc = {0, 1, 0, -1}; 
	
	static void spread() {
		temp = new int[R][C]; 
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 0) continue;
//				System.out.println();
//				System.out.printf("i : %d, j : %d\n", i, j);
			
				
				int cnt = 0; // 확산된 방향의 개수
				int mass = map[i][j] / 5; // 확산되는 양
				
				// 인접한 4방향
				for(int d=0; d<4 ;d++) {
					int nr = i + dr[d]; 
					int nc = j + dc[d]; 				
//					System.out.printf("nr : %d, nc : %d\n", nr, nc);
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue; // 범위를 넘어가면 continue;
					if(map[nr][nc] == -1) continue; // 공기청정기면 continue;
					
					cnt++; 
					temp[nr][nc] += mass; 
				}
				
				temp[i][j] += (map[i][j] - (cnt * mass)); 
			}
		}
		map = temp;
	}
	
}