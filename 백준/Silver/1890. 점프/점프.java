import java.io.*;
import java.util.*;

public class Main {

	static int N, map[][];
	
	public static void main(String[] args) throws Exception {
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

		
		long[][] route = new long[N][N];
		
		route[0][0] = 1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = map[i][j];
				
				if(i == N-1 && j == N-1) continue;
				
				if(i + cnt < N) {
					route[i+cnt][j] += route[i][j];
				}
				
				if(j+cnt < N) {
					route[i][j+cnt] += route[i][j];
				}
			}
		}
		
		System.out.println(route[N-1][N-1]);
	}

}