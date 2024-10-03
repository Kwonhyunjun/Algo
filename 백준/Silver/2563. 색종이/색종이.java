import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine()); 
		
		int[][] map = new int[101][101];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					map[x+j][y+k]++;
				}
			}
		}
		
		int answer = 0; 
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j] > 0) answer++; 
			}
		}
		
		System.out.println(answer); 

	}

}