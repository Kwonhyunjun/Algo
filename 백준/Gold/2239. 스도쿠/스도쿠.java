import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] map;
	static boolean end; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String str = br.readLine(); 
			for(int j=0; j<9; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		dfs(0); 
		
		for (int i = 0; i < 9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(map[i][j]); 
			}
			sb.append("\n"); 
		}
		
		System.out.println(sb.toString());
		
	}

	private static void dfs(int num) {
		if (num == 81) {
			end = true; 
			return;
		}
		
		int r = num / 9;
		int c = num % 9;

		if(map[r][c] != 0) {
			dfs(num+1); 
		}else {
			for(int i=1; i<=9; i++) {
				if(!isVaild(r, c, i)) continue; 
				map[r][c] = i; 
				dfs(num+1); 
				if(end) return;
				map[r][c] = 0 ;
				
			}
		}
	}

	private static boolean isVaild(int r, int c, int n) {
		for(int i=0; i<9; i++) {
			if(map[r][i] == n || map[i][c] == n) return false; 
		}
		
		int rr = r/3*3; 
		int cc = c/3*3; 
		
		for(int i=rr; i<rr+3; i++) {
			for(int j=cc; j<cc+3; j++) {
				if(map[i][j] == n)return false; 
			}
		}
		return true; 
	}
	

}