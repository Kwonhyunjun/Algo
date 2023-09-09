import java.util.Scanner;

/*
 * 
6
10
20
15
25
10
20
 */
public class Main {
	static int N;
	static int[] stairs;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		stairs = new int[N + 1];

		stairs[0] = 0;
		for (int i = 1; i < N + 1; i++) {
			int num = sc.nextInt();
			stairs[i] = num;
		}

		dp = new int[N + 1][2];

		for (int i = 1; i < N + 1; i++) {
			// 한칸 전
			if(i==2) {
				dp[i][0] = dp[i-1][0] + stairs[i];
			}else {
				dp[i][0] = dp[i-1][1] + stairs[i]; 				
			}
			// 두칸 전
			if(i-2 < 0) continue;
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i];
		}
		
		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}

}