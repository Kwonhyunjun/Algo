import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		int last = -1;
		
		for(int i=1; i<=N; i++) {
			int cur = arr[i-1];
			last = Math.max(last, cur + i + 1);
//			System.out.println(cur + " " + (cur + i + 1));
		}

		
		System.out.println(last);
	}

}