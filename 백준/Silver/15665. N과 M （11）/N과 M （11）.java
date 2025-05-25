import java.io.*;
import java.util.*;
	
public class Main {

	static int N, M, arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		solve(0, new int[M]);
		
		System.out.println(sb.toString());

	}
	
	static void solve(int cnt, int[] sel) {
		if(cnt == M) {
			for(int num : sel) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1; //cnt 번째의 직전 선택 값
		for(int i=0; i<N; i++) {
			if(prev == arr[i]) continue;
			sel[cnt] = arr[i];
			prev = arr[i];
			solve(cnt+1, sel);
		}
		
		
	}

}