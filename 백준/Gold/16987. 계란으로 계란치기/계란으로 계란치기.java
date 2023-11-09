import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[][] eggList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		eggList = new int[N][2]; 
		ans = Integer.MIN_VALUE; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			eggList[i][0] = Integer.parseInt(st.nextToken()); 
			eggList[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		dfs(0, 0); 
		System.out.println(ans);
	}

	/**
	 * 
	 * @param n 계란 index
	 * @param cnt 깨진 계란 개수
	 */
	private static void dfs(int n, int cnt) {
		if(ans >= cnt+(N-n)*2) return; 
		
		if(n == N) {
			ans = Math.max(cnt, ans); 
			return; 
		}
		
		// 현재 내 계란이 깨진 경우
		if(eggList[n][0] <= 0) {
			dfs(n+1, cnt);
		}else { // 깨지지 않은 경우 
			boolean flag = false; 
			for(int j=0; j<N; j++) {
				if(n==j || eggList[j][0] <= 0) continue; 
				flag = true; 
				
				eggList[n][0] -= eggList[j][1]; 
				eggList[j][0] -= eggList[n][1]; 
				
				int temp = 0; 
				if(eggList[n][0] <= 0) temp++; 
				if(eggList[j][0] <= 0) temp++;
				
				dfs(n+1, cnt+temp); 
				
				eggList[n][0] += eggList[j][1]; 
				eggList[j][0] += eggList[n][1]; 
			}
			if(!flag) {
				dfs(n+1, cnt); 
			}
		}
		
		
		
	}

}