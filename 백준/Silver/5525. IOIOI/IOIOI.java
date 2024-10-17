import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("I");
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		 
		
		for(int i=0; i<N; i++) {
			sb.append("OI"); 
		}
		
		String string = sb.toString();
		int len = sb.length();
		int answer = 0; 
		
		for(int i=0; i<M-len+1; i++) {
			String part = str.substring(i, i+len); 
			
			if(string.equals(part)) {
				answer++; 
			}
		}
		
		System.out.println(answer);
	}

}