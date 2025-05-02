import java.io.*; 
import java.util.*;

public class Main {

	static int N, M, arr[], sel[];
	static TreeSet<String> set = new TreeSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sel = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); 
		
//		System.out.println(Arrays.toString(arr));
		
		solve(0, 0);
		
//		StringBuilder sb = new StringBuilder(); 
//		
//		for(String str : set) {
//			sb.append(str).append("\n");
//		}
//		
//		System.out.println(sb);
	}

	static void solve(int cnt, int idx) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int n : sel) {
				sb.append(n).append(" ");
			}
			
			if(!set.contains(sb.toString())) {
				set.add(sb.toString());
				System.out.println(sb.toString());
			}
//			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i=idx; i<N; i++) {
			sel[cnt] = arr[i];
			solve(cnt+1, i);
		}
	}
}