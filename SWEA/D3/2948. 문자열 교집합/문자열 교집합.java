import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cnt = 0; 
			
			HashSet<String> set = new HashSet();
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<a; i++) {
				set.add(st.nextToken()); 
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<b; i++) {
				if(set.contains(st.nextElement())) {
					cnt++; 
				}
			}
			
			System.out.println("#"+(t+1)+" "+cnt);
		}
		

	}

}