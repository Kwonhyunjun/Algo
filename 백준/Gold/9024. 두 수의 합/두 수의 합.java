import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			Arrays.sort(arr); 
			
			int cnt = 0, minDiff = Integer.MAX_VALUE;
			
			int lp = 0, rp = N-1; 
			
			while(lp < rp) {
				int a = arr[lp]; 
				int b = arr[rp];
				
				if(K == a+b) {
					lp++; 
					rp--;
				}else if(K < a+b) {
					rp--;
				}else {
					lp++; 
				}
				
				if(Math.abs(K-(a+b)) < minDiff) {
					minDiff = Math.abs(K-(a+b));
					cnt = 1; 
				}else if(Math.abs(K-(a+b)) == minDiff) cnt++; 
			}
			
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}