import java.io.*;
import java.util.*;

public class Main {
	static int M, N, snack[]; 
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); 
		
		snack = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(snack);
		
	
		// 이분탐색 시작
		int s = 1; 			// 시작
		int e = snack[N-1]; 	// 끝
		
		binarySearch(s, e); 
	}

//	private static void binarySearch(int s, int e) {
//		
//		while(s < e) {
////			int mid = (s + e) / 2;
//			int mid = s + (e - s) / 2; 
//			System.out.printf("mid : %d \n", mid);
//			
//			if(check(mid)) {
//				s = mid +1; 
//			}else {
//				e = mid ; 
//			}			
//		}
//		
//		System.out.println(s); 
//	}
//
//	private static boolean check(int mid) {
//		long sum = 0; 
//		
//		for(int i=0; i<N; i++) {
//			sum += snack[i] / mid; 
//		}
//		System.out.printf("sum : %d \n", sum);
//		return sum >= M; 
//		// true : 인원 수 보다 더 많은 사탕 개수 -> 길이를 좀더 늘려도 됨
//		// false : 인원수 보다 더 작은 사 개수
//	}

	private static void binarySearch(int s, int e) {
		int result = 0;
		
		while(s <= e) {
//			int mid = (s + e) / 2;
			int mid = s + (e - s) / 2; 
			int cnt = 0;
			
			for(int i=0; i<N; i++) {		
				cnt += snack[i] / mid;
			}
			
			if(cnt >= M) {
				// 위에서 나눈 갯수가 조카수보다 같거나 많을 경우 
				if(result < mid) result = mid; 
				s = mid + 1;
			}else {
				e = mid -1; 
			}
		}
		
		System.out.println(result); 
	}

}