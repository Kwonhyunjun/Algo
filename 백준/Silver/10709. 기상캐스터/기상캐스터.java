import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		
		for(int i=0; i<H; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int[][] res = new int[H][W];
		for(int i=0; i<H; i++) {
			Arrays.fill(res[i], -1);
		}
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] != 'c') continue;
				
				for(int k=j; k<W; k++) {
					if(k != j && map[i][k] == 'c') break;
					res[i][k] = k-j;
				}
			}
		}

		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}