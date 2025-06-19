import java.io.*;
import java.util.*;
	
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] a = new int[N];
		int[] b = new int[M];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int idxA = 0; 
		int idxB = 0;
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			if(idxA >= N && idxB >= M) {
				break; 
			}
			
			int numA = (idxA >= N) ? Integer.MAX_VALUE : a[idxA];
			int numB = (idxB >= M) ? Integer.MAX_VALUE : b[idxB];
			
			if(numA <= numB) {
				sb.append(numA).append(" ");
				idxA++; 
			}else {
				sb.append(numB).append(" ");
				idxB++; 
			}
		}
		
		System.out.println(sb);

	}

}