import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K; 
	static int[][] map; 
	static int ans; 

	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine()); 
			D= Integer.parseInt(st.nextToken());
			W= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			ans = D; 
			process = new int[D]; 
			Arrays.fill(process, -1);
			
			for(int r=0; r<D; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 약품 넣기
			dfs(0, 0); 
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	/**
	 * 
	 * @param idx 현재 고려해야하는 막 인덱스 
	 * @param cnt 약품 투입 횟수
	 */
	static int[] process; 
	private static void dfs(int idx, int cnt) {
		if(cnt >= ans) return; 
		if(idx == D) {
//			System.out.println(Arrays.toString(process));
			if(available()) {
				ans = Math.min(ans, cnt);
			}
			return; 
		}
		
		// 이 순서를 바꾸면 시간이 더 걸릴까? -> 강사님께 여쭤보기
		
		// 약품 투입 안한 경우
		process[idx] = -1; 
		dfs(idx+1, cnt);
		
		// A 약품 투입 
		process[idx] = 0; 
		dfs(idx+1, cnt+1);
		
		// B 약품 투입
		process[idx] = 1; 
		dfs(idx+1, cnt+1);
	}
	
	private static boolean available() {
		for(int c=0; c<W; c++) { // 열마다 체크
			int cnt = 1; 
			for(int r=1; r<D; r++) {
				int prev = map[r-1][c]; 
				int cur = map[r][c];
				
				if(process[r-1] != -1) {
					prev = process[r-1];
				}
				if(process[r] != -1) {
					cur = process[r];
				}
				
				if(prev == cur) {
					cnt++;
					if(cnt >= K) {
						break; // 해당 열의 안정성 검사가 통과되면 건너뜀
					}
				}else {
					cnt = 1; 
				}
			}
			if(cnt < K) {
				return false; 
			}
		}
		return true;
	}

}