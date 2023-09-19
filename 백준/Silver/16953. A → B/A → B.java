import java.util.Scanner;

public class Main {
	static int N, M;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		ans = Integer.MAX_VALUE; 
		dfs(0, N);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	private static void dfs(int cnt, long start) {
		if(start > M) {
			return; 
		}else if(start == M) {
			ans = cnt+1; 
			return; 
		}else {
			dfs(cnt+1, start*2);
			dfs(cnt+1, Long.parseLong(Long.toString(start) + "1"));
		}
	}
}