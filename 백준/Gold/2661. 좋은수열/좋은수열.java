import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static long answer;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		N = Integer.parseInt(br.readLine()); 
		
//		StringBuilder sb = new StringBuilder(); 
//		
//		for(int i=0; i<N; i++) {
////			System.out.printf("%d번째 자리\n", i+1);
//			for(int j=1; j<4; j++) {
//				sb.append(j);
//				if(isGood(sb)) break;
//				sb.setLength(sb.length()-1);
//			}
//		}
//		
//		System.out.println(sb);
		
		answer = Long.MAX_VALUE;
		solve(0, new StringBuilder());
	}
	
	static void solve(int idx, StringBuilder sb) {
		if(flag) return; 
		
		if(idx == N) {
			System.out.println(sb);
			flag = true; 
			return; 
		}
		
		for(int j=1; j<4; j++) {
			sb.append(j);
			if(isGood(sb)) {
				solve(idx+1, sb);
			}
			sb.setLength(sb.length()-1);
		}
		
	}
	
	static boolean isGood(StringBuilder sb) {
		int len = sb.length(); 
		
		for(int i=1; i<=len/2; i++) {
			
			String str1 = sb.substring(len-(2*i), len-i);
			String str2 = sb.substring(len-i);
			
			
			if(str1.equals(str2)) {
				return false;
			}
			
		}
		
		return true; 
	}


}