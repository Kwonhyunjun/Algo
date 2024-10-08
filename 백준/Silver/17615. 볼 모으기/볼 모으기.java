import java.io.*;
import java.util.*; 

public class Main {
	
	static int red, blue; 
	static String str;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int N = Integer.parseInt(br.readLine()); 
		str = br.readLine(); 
		
		for(int i=0; i<N; i++) {
			if(str.charAt(i) == 'R') red++; 
		}
		
		blue = N - red;
		
//		System.out.printf("red %d blue %d\n", red, blue);
		
		// 왼쪽
		char left = str.charAt(0);
		int i = 1; 
		while(i < N && left == str.charAt(i)) {
			i++; 
		}
		
		int l = 0;
		if(left == 'R') {
			l = Math.min((red - i), blue);
		}else {
			l = Math.min(red, (blue - i)); 
		}
		
		// 오른쪽 
		char right = str.charAt(N-1);
		i = 1;
		int idx = N-2; 
		while(idx >= 0 && right == str.charAt(idx)) {
			idx--; 
			i++;
		}
		
		int r = 0;
		if(right == 'R') {
			r = Math.min((red - i), blue);
		}else {
			r = Math.min(red, (blue - i)); 
		}
		
		System.out.println(Math.min(r, l));
	}

}