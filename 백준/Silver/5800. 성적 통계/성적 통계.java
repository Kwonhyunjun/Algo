import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int gap = -1; 
			for(int i=0; i<N-1; i++) {
				gap = Math.max(Math.abs(arr[i] - arr[i+1]), gap);
			}
			
			sb.append("Class ").append(t).append("\n");
			sb.append("Max ").append(arr[N-1]).append(", ").append("Min ").append(arr[0]).append(", Largest gap ").append(gap).append("\n");
		}

		System.out.println(sb);
	}

}