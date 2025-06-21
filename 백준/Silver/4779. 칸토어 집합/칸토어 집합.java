import java.io.*;
import java.util.*;

public class Main {

	static boolean[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		while((input = br.readLine()) != null) {
			int num = Integer.parseInt(input);
			int len = ((int) Math.pow(3, num));
			arr = new boolean[len];
			solve(0, len);
			
			for(boolean cur : arr) {
				sb.append((cur) ? ' ' : '-');
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}
	
	static void solve(int start, int len) {
		if(len < 3) return;
		
		int third = len / 3;
		
		
		for(int i=start+third; i<start + (2*third); i++) {
			arr[i] = true;
		}
		
		solve(start, third);
		solve(start+ (2*third), third); 
		
	}

}