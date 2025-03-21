import java.io.*;
import java.util.*;

public class Main {
	
	static int N, attack, scv[];
	static int[][][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		scv= new int[3];
		
		for(int i=0; i<N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		
		memo = new int[61][61][61];
		for(int i=0; i<61; i++) {
			for(int j=0; j<61; j++) {
				Arrays.fill(memo[i][j], Integer.MAX_VALUE);
			}
		}
		
		System.out.println(solve(scv[0], scv[1], scv[2]));
	}

	static int[] da = {-9, -9, -3, -1, -1, -3};
	static int[] db = {-3, -1, -9, -9, -3, -1};
	static int[] dc = {-1, -3, -1, -3, -9, -9};
	
	static int solve(int a, int b, int c) {		
		
		if(a <= 0 && b <= 0 && c <= 0) {
			return 0;
		}
//		System.out.println(a + " " + b + " " + c);
		if(memo[a][b][c] != Integer.MAX_VALUE) {
			return memo[a][b][c];
		}
		
		int res = Integer.MAX_VALUE;
		for(int d=0; d<6; d++) {
			int na = (a+da[d] <= 0) ? 0 : a+da[d];
			int nb = (b+db[d] <= 0) ? 0 : b+db[d];
			int nc = (c+dc[d] <= 0) ? 0 : c+dc[d];
			
			res = Math.min(solve(na, nb, nc)+1, res);
		}
		
		return memo[a][b][c] =res;
	}
}