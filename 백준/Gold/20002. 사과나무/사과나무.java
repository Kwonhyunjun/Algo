import java.io.*;
import java.util.*;

public class Main {

	static int N, map[][], prefix[][]; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); 
		map = new int[N][N];
		prefix = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		// 초기화
		prefix[0][0] = map[0][0];
		
		for(int i=1; i<N; i++) {
			prefix[0][i] = prefix[0][i-1] + map[0][i];
			prefix[i][0] = prefix[i-1][0] + map[i][0];
		}
		
//		print();
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				prefix[i][j] = map[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
			}
		}
		
//		print();
		
		int answer = Integer.MIN_VALUE; 
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
//				System.out.println(r + " " + c); 
				int er = r; 
				int ec = c; 
				while(er < N && ec < N) {
//					System.out.println("     " + er + " " + ec);
					
//					if(r == er && c == ec) {
//						answer = Math.max(map[r][c], answer);
//						continue; 
//					}
					
					int res = calc(r, c, er, ec); 
					
					answer = Math.max(answer, res); 
					
					
					er++; 
					ec++; 
				}
			}
		}
		
		System.out.println(answer); 
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(prefix[i])); 
		}
		System.out.println();
	}
	
	static int calc(int sr, int sc, int er, int ec) {
		
		int rect1 = (sr-1 >= 0) ? prefix[sr-1][ec] : 0;
		int rect2 = (sc-1 >= 0) ? prefix[er][sc-1] : 0;
		int rect3 = (sr-1 >= 0 && sc-1 >= 0) ? prefix[sr-1][sc-1] : 0;
		
		return prefix[er][ec] - rect1 - rect2 + rect3; 
		
	}
}