import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int j = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			Integer[] boxes = new Integer[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				boxes[i] = r * c;
			}
			
			Arrays.sort(boxes, Collections.reverseOrder());
			
			int answer = 0; 
			for(int i=0; i<n; i++) {
				if(j <= 0) break;
				
				j -= boxes[i];
				answer++;
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);

	}

}