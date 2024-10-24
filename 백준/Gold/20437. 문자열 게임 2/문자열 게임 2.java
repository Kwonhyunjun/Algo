import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			int K = Integer.parseInt(br.readLine()); 
			int N = str.length();
			
			if(K == 1) { //k가 1일때
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }
			
			int[] alpha = new int[26]; 

			for(int i=0; i<N; i++) {
				alpha[str.charAt(i)-97]++; 
			}
			
			int min = Integer.MAX_VALUE;
			int max = -1; 
			
			for(int l=0; l<N; l++) {
				if(alpha[str.charAt(l)-97] < K) continue; 
				
				int cnt = 1;
				for(int r=l+1; r<N; r++) {
					if(str.charAt(r) == str.charAt(l)) {
						cnt++; 
					}
					
					if(cnt == K) {
						min = Math.min(min, r-l+1);
						max = Math.max(max, r-l+1); 
						break;
					}
				}
			}
			
			if(min == Integer.MAX_VALUE || max == -1) sb.append(-1).append("\n"); 
			else sb.append(min).append(" ").append(max).append("\n"); 
			
		}
		
		System.out.println(sb);

	}

}