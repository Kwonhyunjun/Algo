import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N; 
	static int[] oper, num;
	static int max, min; 
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			oper = new int[4];
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++){
				oper[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE; 
			
			solve(0, num[0]);
			int ans = max - min; 
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}

	private static void solve(int cnt, int res) {
		if(cnt == N-1) {
			max = Math.max(max, res);
			min = Math.min(min, res); 
			return; 
		}
		
		// 더하기
		if(oper[0] > 0) {
			oper[0]--; 
			solve(cnt+1, res+num[cnt+1]);
			oper[0]++;
		}
		
		// 더하기
		if(oper[1] > 0) {
			oper[1]--; 
			solve(cnt+1, res-num[cnt+1]);
			oper[1]++;
		}
		
		// 더하기
		if(oper[2] > 0) {
			oper[2]--; 
			solve(cnt+1, res*num[cnt+1]);
			oper[2]++;
		}
				
		// 더하기
		if(oper[3] > 0) {
			oper[3]--; 
			solve(cnt+1, res/num[cnt+1]);
			oper[3]++;
		}	
	}
	
}