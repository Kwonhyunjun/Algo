import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		int[][] map = new int[26][str.length()+1]; 
		
		for(int i=1; i<=str.length(); i++) {
			char cur = str.charAt(i-1); 
			
			for(int j=0; j<26; j++) {
				map[j][i] = ((cur-'a') == j) ? map[j][i-1] + 1 : map[j][i-1];
			}
		}
		
//		for(int i=0; i<26; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		StringBuilder sb = new StringBuilder();
		
		int q = Integer.parseInt(br.readLine());
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			
			char c = st.nextToken().charAt(0);
			int left = Integer.parseInt(st.nextToken()); 
			int right = Integer.parseInt(st.nextToken());
			
			sb.append(map[c-'a'][right+1] - map[c-'a'][left]).append("\n");
		}
		
		System.out.println(sb);
		
	}

}