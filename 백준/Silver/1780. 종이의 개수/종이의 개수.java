import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], ans;
	static int[] cnt; 

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N]; 
		cnt = new int[3]; 
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(N, 0, 0);
		
		for(int n : cnt) {
			System.out.println(n);
		}
	}

	/**
	 * @param n 한 변의 길
	 * @param sr 시작 행 
	 * @param sc 시작 열 
	 */
	static void solve(int n, int sr, int sc) {
		int num = map[sr][sc]; 
		
		for(int r=sr; r<sr+n; r++) {
			for(int c=sc; c<sc+n; c++) {
				if(map[r][c] != num) {
					// 재귀
					solve(n/3, sr, sc); 
					solve(n/3, sr, sc+(n/3)); 
					solve(n/3, sr, sc+2*(n/3)); 
					solve(n/3, sr+(n/3), sc); 
					solve(n/3, sr+(n/3), sc+(n/3)); 
					solve(n/3, sr+(n/3), sc+2*(n/3)); 
					solve(n/3, sr+2*(n/3), sc); 
					solve(n/3, sr+2*(n/3), sc+(n/3)); 
					solve(n/3, sr+2*(n/3), sc+2*(n/3)); 
					return; 
				}
			}
		}
		
		int idx = (num == -1)? 0 :((num == 1)? 2 : 1); 
		cnt[idx]++; 
	}
}