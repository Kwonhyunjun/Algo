import java.io.*;
import java.util.*;

public class Main {

	static int L, C;
	static char[] alpha, sel; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		
		sel = new char[L];
		solve(0, 0);

	}
	
	static void solve(int cnt, int start) {
		if(cnt == L) {
//			System.out.println(Arrays.toString(sel));
			StringBuilder sb = new StringBuilder();
			
			int vowel = 0;
			int cons = 0;
			
			for(char a : sel) {
				if(a == 'a' || a == 'e' || a == 'i' || a =='o' || a=='u') {
					vowel++;
				}else {
					cons++;
				}
				
				sb.append(a);
			}
			
			if(vowel < 1 || cons < 2) return; 
			
			System.out.println(sb);
			
			return; 
		}
		
		for(int i=start; i<C; i++) {
			sel[cnt] = alpha[i];
			solve(cnt+1, i+1);
		}
	}

}