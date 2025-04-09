import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[], answer;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		v = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, new int[N]);
		
		System.out.println(answer);
	}
	
	static void solve(int idx, int[] select) {
		if(idx == N) {
//			System.out.println(Arrays.toString(select)); 
			int res = 0;
			for(int i=0; i<N-1; i++) {
				res += Math.abs(select[i] - select[i+1]); 
			}
//			System.out.println(res);
			answer = Math.max(res, answer);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			select[idx] = arr[i];
			solve(idx+1, select);
			v[i] = false;
		}
	}

}