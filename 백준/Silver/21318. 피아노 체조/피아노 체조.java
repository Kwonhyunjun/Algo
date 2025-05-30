import java.io.*; 
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(level));
		
		int[] prefix = new int[N+1]; 
		for(int i=1; i<=N; i++) {
			prefix[i] = prefix[i-1];
			if(i != N && arr[i] > arr[i+1]) prefix[i]++; 
		}
		
//		System.out.println(Arrays.toString(prefix));
		
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int res = prefix[b] - prefix[a-1];
			if(b != N && arr[b] > arr[b+1]) res--;
			sb.append(res).append("\n");
		}
		
		System.out.println(sb);

	}

}