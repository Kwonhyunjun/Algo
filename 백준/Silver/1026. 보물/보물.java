import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] asc = new Integer[N];
		Integer[] desc = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			asc[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			desc[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(asc);
		Arrays.sort(desc, Collections.reverseOrder());
		
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			answer += asc[i] * desc[i]; 
		}
		
		System.out.println(answer);
		
		

	}

}