import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine(); 
		String p = br.readLine();
		int s_len = s.length();
		int p_len = p.length();
		 
		HashMap<Character, List<Integer>> map = new HashMap<>();
		
		for(int i=0; i<s_len; i++) {
			char c = s.charAt(i);
			
			map.putIfAbsent(c, new ArrayList<>());
			map.get(c).add(i);
		}
		
		int start = 0; 
		int cnt = 0; 
		
		while(start < p_len) {
			// 문자열 P를 다 순회
			
			char c = p.charAt(start);
//			System.out.printf("현재 문자열 : %c(%d)\n", c, start); 
			
			int max = 1;
			for(int idx : map.get(c)) {
//				System.out.printf("	인덱스 : %d\n", idx); 
				int len = 1;
				
				
				while((idx+len-1) < s_len && (start+len-1) <p_len) {
					if(!s.substring(idx, idx+len).equals(p.substring(start, start+len))) break;
					max = Math.max(max, len); 
					len++; 
				}
				
				
			}
//			System.out.printf("	최대길이 : %d\n", max);
			
//			System.out.printf("%d~%d => %s\n", start, start+max, p.substring(start, start+max));
			
			cnt++; 
			start += max; 
			
		}
		
		System.out.println(cnt);
	}

}