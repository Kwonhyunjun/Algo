import java.io.*;
import java.util.*; 

public class Main {

	static int N, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		char[] arr = br.readLine().toCharArray(); 
		boolean[] eaten = new boolean[N];
		
		int answer = 0; 
		
		for(int i=0; i<N; i++) {
			char cur = arr[i];
			if(cur == 'P') {
				for(int j=-K; j<=K; j++) {
					int idx = i + j; 
					
					if(j == 0 || (idx < 0 || idx >= N)) continue;
					
					if(arr[idx] == 'H' && !eaten[idx]) {
						answer++; 
						eaten[idx] = true;
						break; 
					}
				}
			}
		}
		
		System.out.println(answer);
		
		

	}

}