import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			int dist = Y - X; 
			
			int sr = (int) Math.sqrt(dist); 
			int square = (int) Math.pow(sr, 2);
			
			
			if(dist == square) {
				sb.append(sr*2-1).append("\n");
			}else if(dist <= square + sr) {
				sb.append(sr*2).append("\n");
			}else {
				sb.append(sr*2+1).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
}