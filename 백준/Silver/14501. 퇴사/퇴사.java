import java.util.Scanner;

public class Main {
	static int N, ans; 
	static int[][] map; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][2];
		
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[i][0] = a; 
			map[i][1] = b;
		}
		// Input End 
		ans = Integer.MIN_VALUE;
		dfs(0, 0);
		System.out.println(ans);
	}

	private static void dfs(int start, int money) {
		if(start >= N) {
			ans = Math.max(ans, money);
			return; 
		}
		
		// 상담 O
		if(start+map[start][0] > N) {
			dfs(start+1, money);
		}else {
			dfs(start+map[start][0], money+map[start][1]);			
		}
		
		// 상담 X
		dfs(start+1, money);
	}
}