import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] alpha = new int[26];
		
		for(char cur : str.toCharArray()) {
			alpha[cur -'A']++;
		}
		
		boolean canPalindrom = true;
		boolean isEven = str.length() % 2 == 0;
		char middle = 'a';
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<26; i++) {
			if(alpha[i] == 0) continue;
			
			if(alpha[i] % 2 == 1) {
				if(isEven) {
					canPalindrom = false;
					break;
				}else {
					if(middle == 'a') {
						middle = (char) ('A' + i);
					}else {
						canPalindrom = false;
						break;
					}
				}
			}
			
			String cur = String.valueOf((char) ('A' + i));
			sb.append(cur.repeat(alpha[i]/2));
		}
		
		if(!canPalindrom) {
			sb.setLength(0); 
			sb.append("I'm Sorry Hansoo");
		}else {
			String reverse = sb.reverse().toString();
			sb.reverse();
			if(!isEven) sb.append(middle);
			sb.append(reverse);
		}

		System.out.println(sb);
	}

}