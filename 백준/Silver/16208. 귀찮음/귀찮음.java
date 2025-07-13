import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int rest = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			rest += arr[i];
		}
		
		Arrays.sort(arr); 
		
		long answer = 0;
		for(int i=0; i<N-1; i++) {
			rest -= arr[i];
			answer += (arr[i] * (rest));
			
		}
		
		System.out.println(answer);
		

	}

}