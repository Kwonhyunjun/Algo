import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[], S, answer;
	static boolean v[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		S = Integer.parseInt(br.readLine());
		v = new boolean[N];
		
		solve(S-1);
		
		System.out.println(answer);

	}
	
	static int[] dd = {1, -1};
	
	static void solve(int s) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(s);
		v[s] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
//			System.out.println(cur);
			answer++;
			
			for(int d : dd) {
				int nxt = cur + (d * arr[cur]);
//				System.out.println("nxt: " + nxt);
				
				if(nxt < 0 || nxt >= N) continue;
				if(v[nxt]) continue;
				
				q.offer(nxt);
				v[nxt] = true;
			}
		}
	}

}