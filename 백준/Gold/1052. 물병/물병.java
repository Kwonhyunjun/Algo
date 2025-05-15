import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		while(true) {
			String str = Integer.toBinaryString(N);
//			System.out.println(N);
			int cnt = 0;
			for(char c : str.toCharArray()) {
				if(c == '1') cnt ++; 
			}
			
			if(cnt <= K) break;
			
			answer++; 
			N++;
		}
		
		System.out.println(answer);

	}

}