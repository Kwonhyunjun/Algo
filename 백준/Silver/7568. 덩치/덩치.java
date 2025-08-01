import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		int[] ranks = new int[N]; 

		for(int i=0; i<N; i++) {
			int rank = 1;
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
					rank++;
			}
			
			ranks[i] = rank;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(ranks[i]).append(" ");
		}
		
		System.out.println(sb);
		

	}

}