import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, arr[], change[], prefix[]; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N]; 
		change = new int[N+1];
		prefix = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			change[a-1] += k;
			change[b] += -k;
			
//			System.out.println(Arrays.toString(change));	
		}
		

		prefix[0] = change[0];
		for(int j=1; j<=N; j++) {
			prefix[j] = prefix[j-1] + change[j];
		}
		
//		System.out.println(Arrays.toString(prefix)); 
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i] + prefix[i] + " "); 
		}
	}

}