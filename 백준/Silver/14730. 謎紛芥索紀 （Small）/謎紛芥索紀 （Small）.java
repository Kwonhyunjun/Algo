import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int c = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			answer += c * k;
		}
		
		System.out.println(answer);

	}

}