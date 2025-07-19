import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			int num = i;
			while(num > 0) {
				int digit = num % 10; 
				if(digit == D) {
					answer++;
				}
				num /= 10;
			}
		}
		
		System.out.println(answer);
		
		

	}

}
