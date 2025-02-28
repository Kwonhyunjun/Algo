import java.io.*;
import java.util.*;

public class Main {

	static String str;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		arr = str.toCharArray();
		
		int len = arr.length; 
		int count = 0;
		for(int i=0; i<len; i++) {
			if(arr[i] == 'a') count++;
		}
		
		int answer = 1001;
		
		for(int i=0; i<len; i++) {
			int bCnt = 0; 
			for(int j=0; j<count; j++) {
				int idx = (i+j) % len; 
				
				if(arr[idx] == 'b') bCnt++; 
			}
			
			answer = Math.min(answer, bCnt);
		}
		
		System.out.println(answer);
	}

}