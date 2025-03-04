import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static char[][] map;
	static int[][][] prefix;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(br.readLine());
		
		map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 누적합
		prefix = new int[3][N+1][M+1];
		
		for(int type = 0; type<3; type++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					int cur = ((type == 0 && map[i-1][j-1] == 'J') || (type == 1 && map[i-1][j-1] == 'O') || (type == 2 && map[i-1][j-1] == 'I')) ? 1 : 0; 
					prefix[type][i][j] = prefix[type][i-1][j] + prefix[type][i][j-1] - prefix[type][i-1][j-1] + cur;
				}
			}
		}
		
//		print();
		
		StringBuilder sb = new StringBuilder(); 
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int type=0 ; type <3; type++) {
				int cnt = prefix[type][c][d] -(prefix[type][a-1][d] + prefix[type][c][b-1])  + prefix[type][a-1][b-1];
				sb.append(cnt).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	
//	static void print() {
//		for(int i=0; i<3; i++) {
//			System.out.println((i == 0) ? "Jungle" : (i == 1) ? "Ocean" : "Ice");
//			for(int j=0; j<=N; j++) {
//				System.out.println(Arrays.toString(prefix[i][j]));
//			}
//			System.out.println(); 
//		}
//	}

}