import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static long map[][];
	static boolean[][][] work;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken())+1;
		
		map = new long[N][M];
		work = new boolean[2][N][M];
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if(a == c) {
				work[0][a][Math.max(b, d)] = true; 
			}else {
				work[1][Math.max(a, c)][b] = true;
			}
		}
		
		
		for(int i=0; i<M-1; i++) {
			if(work[0][0][i+1]) break;
			
			map[0][i+1] = 1;
		}
		
		for(int i=0; i<N-1; i++) {
			if(work[1][i+1][0]) break;
			
			map[i+1][0] = 1;
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i])); 
//		}
		
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				long a = (work[1][i][j]) ? 0 : map[i-1][j];
				long b = (work[0][i][j]) ? 0 : map[i][j-1];
				map[i][j] = a + b;
			}
		}
		
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i])); 
//		}
		
		System.out.println(map[N-1][M-1]);
	}

}