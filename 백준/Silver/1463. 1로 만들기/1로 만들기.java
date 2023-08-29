import java.util.Arrays;
import java.util.Scanner;


// 상향식 메모이제이션

public class Main {
	static int N; 
	static int res = Integer.MAX_VALUE; 
	static int[] dp; 
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt(); 
		// Input End 
		
		dp = new int[N+1]; 
		
		// 기저조건
		dp[1] = 0; 

		for(int i = 2; i <= N; i++) {
			// 1  빼기
			dp[i] = dp[i-1] + 1; 
			// 2 나누기(나누어 떨어지면)
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			// 3 나누기(나누어 떨어지면)
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		// 구현
		System.out.println(dp[N]);
	}

}
