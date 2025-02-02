import java.io.*;
import java.util.*;

public class Main {
	
	static int N, minR, maxR, minC, maxC, cur[], dir; 
	static List<int[]> traces; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String moves = br.readLine();
		
		traces = new ArrayList<>();
		
		cur = new int[] {0, 0};
		traces.add(new int[] {0, 0}); 
		dir = 0; 
		
//		for(int[] trace : traces) {
//			System.out.println(Arrays.toString(trace));
//		}
		
		for(char move : moves.toCharArray()) {
//			System.out.printf("현재 방향 : %d, map[%d][%d]\n", dir, cur[0], cur[1]);
			
			if(move == 'F') {
				cur[0] += dr[dir];
				cur[1] += dc[dir];
				traces.add(new int[] {cur[0], cur[1]});
				minR = Math.min(minR, cur[0]);
				maxR = Math.max(maxR, cur[0]);
				minC = Math.min(minC, cur[1]);
				maxC = Math.max(maxC, cur[1]);
//				System.out.println("이동 : " + Arrays.toString(cur));
			}else {
				rotate(move);
//				System.out.println("회전 : " + dir);
			}
			
		}
		
		int fixR = Math.abs(minR);
		int fixC = Math.abs(minC);
		
		int R = maxR + fixR + 1;
		int C = maxC + fixC + 1;
//		System.out.println(maxR + " " + maxC);
//		System.out.println(" : "+ R + " " + C);
//		System.out.println("fix : "+fixR + " " + fixC);
				
		char[][] map = new char[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(map[i], '#');
		}

		
		for(int[] trace : traces) {
//			System.out.println((trace[0]+fixR) + " " + (trace[1]+fixC));
			map[trace[0]+fixR][trace[1]+fixC] = '.';
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, -1, 0, 1};
	
	static void rotate(char d) {
		if(d == 'R') {
			dir = (dir+1 < 4) ? dir+1 : 0; 
			
		}else {
			dir = (dir-1 >= 0) ? dir -1 : 3; 
		}
	}

}