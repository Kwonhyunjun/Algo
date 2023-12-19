import java.util.*;


public class Main {
	static int N;	// 원소 개수
	static int[] U;	// 집합
	static ArrayList<Integer> sum2;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		U = new int[N];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			U[i] = scanner.nextInt();
		}
		
		// 두 수의 합 구하기
		sum2 = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sum2.add(U[i] + U[j]);
			}
		}
		
		// 정렬
		Arrays.sort(U);
		Collections.sort(sum2);
		
		for(int i = N - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {	// U[i]보다 U[j]가 작아야됨 
				int gap = U[i] - U[j];
				
				// gap이 sum 배열에 있는지 이분탐색으로 찾음
				if(search(gap) && U[i] > answer) {
					answer = U[i];
				}
			}
		}
		System.out.println(answer);
	}
	
	static boolean search(int n) {
		int s = 0;
		int f = sum2.size() - 1;
		int m;
		
		while(s < f) {
			m = (s + f) / 2;
			
			if(sum2.get(m) < n) {
				s = m + 1;
			}
			else if(sum2.get(m) > n) {
				f = m - 1;
			}
			else if(sum2.get(m) == n) {
				return true;
			}
		}
		
		return false;
	}

}