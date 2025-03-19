import java.io.*;
import java.util.*;

public class Main {
	
	static int N, sel[];
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		v = new boolean[N+1];
		sel = new int[N];
		
		solve(0);

		System.out.println(sb);
	}

	static void solve(int cnt) {
		if(cnt == N) {
//			System.out.println(Arrays.toString(sel));
			for(int num : sel) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(v[i]) continue;
			v[i] = true;
			sel[cnt] = i;
			solve(cnt+1);
			v[i] = false;
		}
	}
}