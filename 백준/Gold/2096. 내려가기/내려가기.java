import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][3];
		int[][] min = new int[N][3];
		int[][] max = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기화
		for(int i=0; i<N; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
			Arrays.fill(max[i], Integer.MIN_VALUE);
		}
		for(int i=0; i<3; i++) {
			min[0][i] = max[0][i] = map[0][i];
		}
		
		for(int i=1; i<N; i++) {
			
			for(int j=0; j<3; j++) {
				for(int k=-1; k<2; k++) {
					
					int idx = j+k;
					if(idx < 0 || idx >=3) continue; 
					min[i][j] = Math.min(min[i][j], min[i-1][idx] + map[i][j]);
					max[i][j] = Math.max(max[i][j], max[i-1][idx] + map[i][j]);
				}
			}
				
		}
		
		int min_answer = Integer.MAX_VALUE;
		int max_answer = Integer.MIN_VALUE;
		
		for(int i=0; i<3; i++) {
			min_answer = Math.min(min_answer, min[N-1][i]);
			max_answer = Math.max(max_answer, max[N-1][i]);
		}
		
		System.out.println(max_answer + " " + min_answer); 
		

	}

}