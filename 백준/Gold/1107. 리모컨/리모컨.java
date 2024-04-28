import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, M, ans, K, num[];
	static boolean[] v; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine()); 
		K = String.valueOf(N).length(); 
		num = new int[K]; 
		
		v = new boolean[10];
		Arrays.fill(v, true);
		
		if(M>0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int idx = Integer.parseInt(st.nextToken());
				v[idx] = false;
			}			
		}
		

		ans = Math.abs(N-100);
		
		if(N == 100) {
			ans = 0; 
		}else {
			dfs(0, 0); 
		}
		
		System.out.println(ans);
		
	}
	
	static public void dfs(int idx, int click){ 
		for(int i=0; i<10; i++) {
			if(v[i]) {
				int newBtn = click * 10 + i;
				int cnt = Math.abs(N - newBtn) + String.valueOf(newBtn).length();
				ans = Math.min(cnt, ans); 
				
				if(idx < 6) {
					dfs(idx + 1, newBtn); 
				}
			}
		}
	}

}