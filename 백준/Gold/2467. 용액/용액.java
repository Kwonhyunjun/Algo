import java.io.*;
import java.util.*;

public class Main {

	static int N, fluid[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		
		fluid = new int[N]; 
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			fluid[i] = Integer.parseInt(st.nextToken()); 
		}
		
//		두 용액 합 특성 -> 0에 가까워야한다. 
//		두 용액의 특성 알야한다.
//		for(int i 0 ~ n)
//			int num = arr[i]; // -99 
//				99 -> 이진 탐색(99); lowerBound()

		long min = Long.MAX_VALUE;
		int ml = 0; int mr = 0; 
		
		for(int i=0; i<N ;i++) { 
			
			int left = i+1; // int left = 0; 
			int right = N-1; 
			
			while(left <= right) {
				int mid = left + (right - left) / 2;
				
				long sum = Math.abs(fluid[i] + fluid[mid]);
//				System.out.printf("fluid[%d](%d) + fluid[%d](%d) = %d\n", i,fluid[i], mid,fluid[mid], sum);
				
//				if(fluid[mid] <= target) {
//					minIdx = Math.min(minIdx, mid); 
//					right = mid -1; 
//				}else {
//					left = mid + 1; 
//				}
				
				if(min > sum) {
					min = sum; 
					ml = i; mr = mid; 
				}
				
				if(fluid[mid] >= -fluid[i]) {
					right = mid - 1;
				}else {
					left = mid + 1; 
				}
			}
			
//			System.out.printf("%d %d\n", fluid[ml], fluid[mr]);
		}
		System.out.printf("%d %d\n", fluid[ml], fluid[mr]);
	}

}