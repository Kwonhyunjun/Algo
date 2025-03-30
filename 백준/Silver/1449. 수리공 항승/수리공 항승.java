import java.io.*;
import java.util.*;

public class Main {
	
	static int N, L, leak[]; 
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		leak = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			leak[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(leak);
		
		int cnt = 1;
		int start = leak[0]; 
		
		
		
		for(int i=1; i<N; i++) {
//			System.out.println((start + L -1) + " " + leak[i]);
			if(start + L -1 < leak[i]) {
				cnt++;
				start = leak[i];
			}
		}
		
		System.out.println(cnt);

	}

}