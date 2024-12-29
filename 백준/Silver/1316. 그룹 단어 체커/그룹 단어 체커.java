import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0; 
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			int[] alpha = new int[26];
			Arrays.fill(alpha, -1);
			
			boolean flag = true;
			for(int j=0; j<str.length(); j++) {
				char cur = str.charAt(j);
				int idx = cur - 'a';
				
				int last = alpha[idx];
				if(last != -1 && Math.abs(last - j) != 1) {
					flag = false;
					break;
				}
				
				alpha[idx] = j;
			}
			
			if(flag) answer++;
		}
		
		System.out.println(answer);
		

	}

}