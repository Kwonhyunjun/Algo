import java.io.*;
import java.util.*;

public class Main {
	
	static int N, nums[];
	static long min, max; 
	static String minS, maxS; 
	static char[] sign;
	static boolean[] v;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sign = new char[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		
		nums = new int[N+1];
		v = new boolean[10];
		solve(0, 0);
		System.out.println(maxS + "\n" + minS);
	}
	
	static void solve(int num, int cnt) {
		if(cnt > N) {
			if(check()) {
//				System.out.println(Arrays.toString(nums));
				StringBuilder sb = new StringBuilder();
				for(int n : nums) {
					sb.append(n);
				}
				
				long n2 = Long.parseLong(sb.toString());
//				System.out.println(n2);
				if(min > n2) minS = sb.toString();
				if(min < n2) maxS = sb.toString();
				min = Math.min(n2, min);
				max = Math.max(n2, max);
			}
			return;
		}
		
		int start = 0; int end = 9;
		for(int i=start; i<=end; i++) {
			if(v[i]) continue;
			v[i] = true;
			nums[cnt] = i;
			solve(i, cnt+1); 
			v[i] = false;
		}
	}
	
	static boolean check() {
		for(int i=0; i<N; i++) {
//			System.out.println(sign[i]);
//			System.out.println(nums[i] + " " + nums[i+1]);
			if((sign[i] == '<' && nums[i] > nums[i+1]) || (sign[i] == '>' && nums[i] < nums[i+1])) {
//				System.out.println("탈락");
				return false;
				
			}
		}
		return true;
	}

}