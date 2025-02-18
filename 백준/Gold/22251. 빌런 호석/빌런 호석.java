import java.io.*;
import java.util.*;

public class Main {

	static int K, P, curDigits[], answer;
	static String N, X;
	static int[][] leds = new int[10][7];
//	static int[][] leds = {{1, 1, 1, 0, 1, 1, 1}, //0
//            {0, 0, 1, 0, 0, 0, 1}, //1
//            {0, 1, 1, 1, 1, 1, 0}, //2
//            {0, 1, 1, 1, 0, 1, 1}, //3
//            {1, 0, 1, 1, 0, 0, 1}, //4
//            {1, 1, 0, 1, 0, 1, 1}, //5
//            {1, 1, 0, 1, 1, 1, 1}, //6
//            {0, 1, 1, 0, 0, 0, 1}, //7
//            {1, 1, 1, 1, 1, 1, 1}, //8
//            {1, 1, 1, 1, 0, 1, 1}}; //9

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		N = st.nextToken();
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = st.nextToken();
		
		curDigits = getDigits(X);
		
		leds[0] = new int[]{1, 1, 1, 0, 1, 1, 1};
		leds[1] = new int[]{0, 0, 1, 0, 0, 0, 1};
		leds[2] = new int[]{0, 1, 1, 1, 1, 1, 0};
		leds[3] = new int[]{0, 1, 1, 1, 0, 1, 1};
		leds[4] = new int[]{1, 0, 1, 1, 0, 0, 1};
		leds[5] = new int[]{1, 1, 0, 1, 0, 1, 1};
		leds[6] = new int[]{1, 1, 0, 1, 1, 1, 1};
		leds[7] = new int[]{0, 1, 1, 0, 0, 0, 1};
		leds[8] = new int[]{1, 1, 1, 1, 1, 1, 1};
		leds[9] = new int[]{1, 1, 1, 1, 0, 1, 1};

		int maxN = Integer.parseInt(N);
		int curX = Integer.parseInt(X);

		for (int i = 1; i <= maxN; i++) {
			if (i != curX && isPossible(String.valueOf(i))) {
				answer++; 
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean isPossible(String target) {
		int cnt = 0;
		int[] targetDigits = getDigits(target);

		// 현재 층과 동일한 경우 제외
		if (Arrays.equals(curDigits, targetDigits)) return false;

		for (int i = 0; i < K; i++) {
			if (curDigits[i] == targetDigits[i]) continue;
			int curCnt = 0;
			for (int j = 0; j < 7; j++) {
				if (leds[curDigits[i]][j] != leds[targetDigits[i]][j]) {
					curCnt++; 
				}
			}
			cnt += curCnt;
		}
		
		return cnt > 0 && cnt <= P;
	}

	static int[] getDigits(String num) {
		int[] res = new int[K];
		Arrays.fill(res, 0);  // 기본적으로 0으로 초기화
		int idx = 0;
		for (int i = K - num.length(); i < K; i++) {
			res[i] = num.charAt(idx++) - '0'; 
		}
		return res;
	}
}