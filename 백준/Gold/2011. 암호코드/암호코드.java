import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine().trim();
		int mod = 1000000;

		if (num.charAt(0) == '0') {
			System.out.println(0);
			return;
		}

		int len = num.length();
		int[] dp = new int[len + 1]; // dp[i]는 i번째까지 해석 가능한 경우의 수
		dp[0] = 1; // 초기 상태
		dp[1] = 1;

		for (int i = 2; i <= len; i++) {
			char curr = num.charAt(i - 1);
			char prev = num.charAt(i - 2);

			if (curr >= '1' && curr <= '9') {
				dp[i] = dp[i - 1];
			}

			int twoDigit = (prev - '0') * 10 + (curr - '0');
			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] = (dp[i] + dp[i - 2]) % mod;
			}
		}

		System.out.println(dp[len]);
	}
}