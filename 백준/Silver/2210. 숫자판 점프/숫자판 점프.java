import java.io.*;
import java.util.*;

public class Main {
	
	static int map[][];
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[5][5];
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				solve(i, j, 0, new StringBuilder());
			}
		}
		
		System.out.println(set.size());
	}
	
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};
	
	static void solve(int i, int j, int cnt, StringBuilder sb) {
		if(cnt == 6) {
//			System.out.println(sb);
			set.add(sb.toString());
			return;
		}
		
		sb.append(map[i][j]);
		
		for(int d=0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr < 0 || nc < 0 || nr >=5 || nc >=5) continue;
			
			solve(nr, nc, cnt+1, sb);
		}
		
		sb.setLength(sb.length()-1);
	}

}