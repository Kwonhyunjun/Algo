import java.io.*;
import java.util.*;

public class Main {
	
	static int N, L, R, X, problem[], answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		problem = new int[N]; 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			problem[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0; 
		
		solve(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
		
		System.out.println(answer);
	}
	
	static void solve(int idx, int max, int min, int sum, int cnt) {
		if(idx == N) {
			if(cnt < 2) return;
			if(sum < L || sum > R) return;
			if(max - min < X) return;
			answer++;
			return;
		}
		
		int cur = problem[idx]; 
		
		solve(idx+1, Math.max(max, cur), Math.min(min, cur), sum+cur, cnt+1);
		solve(idx+1, max, min, sum, cnt); 
	}

}