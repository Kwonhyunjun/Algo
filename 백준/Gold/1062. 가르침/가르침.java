import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, answer; 
	static String[] vocas; 
	static boolean[] teach = new boolean[26]; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 남극언어 단어 개수 
		K = Integer.parseInt(st.nextToken()); // K개의글자를 가르칠 시간 밖에 없다
		
		vocas = new String[N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			String middle = str.substring(4, str.length()-4);
			
			vocas[i] = middle; 
		}
		
		answer = -1; 
		
		if(K < 5) {
			answer = 0;
		}else {
			teach['a'-'a'] = true;
			teach['n'-'a'] = true;
			teach['t'-'a'] = true;
			teach['i'-'a'] = true;
			teach['c'-'a'] = true;
			
			learn(1, K-5);
			
		}
		
		System.out.println(answer);
		
	}
	
	static void learn(int idx, int cnt) {
		if(cnt == 0) {
			int can = 0;
			for(String voca : vocas) {
				boolean flag = true; 
				for(char c : voca.toCharArray()) {
					if(!teach[c - 'a']) {
						flag = false; 
						break; 
					}
				}
				if(flag) can++;
			}
			answer = Math.max(can, answer);
			
			return; 
		}
		
		for(int i=idx; i<26; i++) {
			if(teach[i]) continue; 
			
			teach[i] = true;
			learn(i+1, cnt-1);
			teach[i] = false;
		}
		
	}

}