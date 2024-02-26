import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int t=1; t<T+1; t++) {
			st = new StringTokenizer(br.readLine()); 
			
			int N = Integer.parseInt(st.nextToken()); 
			int M = Integer.parseInt(st.nextToken()); 
			
			int X = (1 << N) -1; 
			
			if((M & X) == X) {
				System.out.printf("#%d ON\n", t);
			}else {
				System.out.printf("#%d OFF\n", t);
			}
			
		}

	}

}