import java.io.*;
import java.util.*;

public class Main {

	static int N, M, nums[], sel[];
	static boolean[] v;
	static HashSet<String> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		sel = new int[M];
		Arrays.sort(nums);
		
		solve(0, 0);
		
		System.out.println(answer);
		
	}
	static StringBuilder answer = new StringBuilder();
	static StringBuilder sb;
	static void solve(int cnt, int start) {
		if(cnt == M) {
			sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			
			if(set.contains(sb.toString())) return; 
//			System.out.println(Arrays.toString(sel));
			set.add(sb.toString());
			answer.append(sb.toString()).append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			sel[cnt] = nums[i];
			v[i] = true;
			solve(cnt+1, i+1);
			v[i] = false;
		}
		
	}
}