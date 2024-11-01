import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, arr[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		arr = new int[N];
		int left = Integer.MAX_VALUE;
		int right = 0; 
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right += arr[i];
			left = Math.min(left, arr[i]);
		}
		
		int answer = Integer.MAX_VALUE;
		
		while(left <= right) {
			int mid = left + (right-left) / 2; 
			
//			System.out.printf("%d~%d => %d \n", left, right, mid);
			
			int res = isPossible(mid);
			
//			if(res == -1) {
//				// 시간을 줄여
//				right = mid - 1; 
//			}else if(res == -2) {
//				// 시간을 늘려 
//				left = mid + 1;
//			}else {
//				right = mid - 1;
//				answer = Math.min(answer, res);
//			}
			
			if(res == -1) {
				left = mid + 1;
			}else {
				right = mid - 1;
				answer = Math.min(answer, res);
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int isPossible(int mid) {
		
		int cnt = 0;
		int max = 0; 
		
		int cur = arr[0]; 
		
		for(int i=1; i<N; i++) {
			if(cur+arr[i] > mid) {
//				System.out.printf("%d까지 cur : %d\n", i-1, cur);
				cnt++;
				max = Math.max(max, cur);
				cur = arr[i];
			}else {
				cur += arr[i];
			}
		}
		
		if(cur > 0) {
			cnt++;
			max = Math.max(max, cur);
		}
		
//		System.out.printf("cnt : %d, max : %d\n", cnt, max);
//		if(cnt == 3) {
//			return max;
//		}else if (cnt < 3) {
//			// 시간을 줄여
//			return -1; 
//		}else {
//			return -2; 
//		}
		
		if(cnt <=M) {
			return max;
		}else {
			return -1; 
		}
	}
}