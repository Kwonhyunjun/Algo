import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("I");
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		char[] str = br.readLine().toCharArray();
		 
		
		int answer = 0; 
		for(int i=0; i<M; i++) {
			
			int k = 0; // IOI의 개수
			if(str[i] == 'O') continue;
			
			while(i+2 < M && str[i+1] == 'O' && str[i+2] == 'I') {
				k++; 
				
				if(k==N) {
					answer++;
					k--; 
				}
				i += 2; 
			}
		}
		
		
		
		
		System.out.println(answer);
	}

}