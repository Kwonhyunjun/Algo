import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder out = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			
			StringBuilder sb =new StringBuilder();
			for(char c : st.nextToken().toCharArray()) {
				for(int j=0; j<R; j++) { 
					sb.append(c);
				}
			}
			
			out.append(sb).append("\n");
		}
		
		System.out.println(out);

	}

}