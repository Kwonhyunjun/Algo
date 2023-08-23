import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ans; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트 케이스 수 읽기
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수만큼 반복
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] inputs = new int[N]; 
			boolean[] v = new boolean[N]; 
			
			st = new StringTokenizer(br.readLine()); 	
			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				inputs[i] = a; 
			}
			// Input End
			
			ans = 0; 
			perm(0, 0, 0, inputs, v, N); 
			System.out.println("#"+t+" "+ans);
		}
	}	


	static void perm(int cnt, int right, int left, int[] inputs, boolean[] v, int N) {
		if(right > left) return; 
		
		if(cnt == N) {
			ans++; 
			return; 
		}
		
		for(int i=0;i<N;i++) {
			if(v[i]) continue;
			v[i] = true;
			perm(cnt+1, right+inputs[i], left, inputs, v, N); 
			perm(cnt+1, right, left+inputs[i], inputs, v, N); 
			v[i] = false;
		}
	}
	


}
