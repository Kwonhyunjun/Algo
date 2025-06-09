import java.io.*;
import java.util.*;

public class Main {
	
	static int num, answer;
	static char[] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String X = br.readLine();
		num = Integer.parseInt(X);
		arr = X.toCharArray();
		answer = Integer.MAX_VALUE;
		
		solve(0, new char[arr.length], new boolean[arr.length]);
		
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
	
	static void solve(int idx, char[] res, boolean[] v) {
		if(idx == arr.length) {
			StringBuilder sb = new StringBuilder();
			for(char cur : res) {
				sb.append(cur);
			}
			int c = Integer.parseInt(sb.toString());
			
			if(c > num) {
				answer = Math.min(answer, c);
			}
			return; 
		}
		
		for(int i=0; i<arr.length; i++) {
			if(v[i]) continue;
			if(idx == 0 && arr[i] == '0') continue;
			
			res[idx] = arr[i];
			v[i] = true;
			solve(idx+1, res, v);
			v[i] =false;
		}
		
		
	}

}