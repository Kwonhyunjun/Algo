import java.io.*;
import java.util.*;

public class Main {
	static String S, T;
	static StringBuilder sb;
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();
		
		sb  = new StringBuilder(T);
		check(); 
		System.out.println(0);
		
	}
	
	static void check() {
		if(sb.length() == S.length()) {
			if(S.equals(sb.toString())) {
				System.out.println(1);
				System.exit(0);
			}
			return; 
		}
		
//		System.out.println(sb);
		
		if(sb.charAt(sb.length()-1) == 'A') {
			sb.setLength(sb.length()-1);
			check();
			sb.append("A");
		}
		
		if(sb.charAt(0) == 'B') {
			sb.reverse().setLength(sb.length()-1);
			check();
			sb.append("B").reverse();
		}
	}
}