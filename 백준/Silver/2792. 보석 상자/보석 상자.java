import java.io.*;
import java.util.*; 

/*
 * 질투심은 가장 많은 보석을 가져간 학생
 * 질투심이 최소가 되게 보석을 나누어 주는 방법 -> 가장 공평하게 나눠주는 방법
 * */

public class Main {
	
	static int N, M, arr[]; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		int max = 0; 
		
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
			max = Math.max(arr[i], max); 
		}
		
		int left = 1; 
		int right = max; 
		
		int answer = Integer.MAX_VALUE; 
		
		while(left <= right) {
			
			int mid = left + (right-left)/2; 
			
			if(check(mid)) {
				right = mid - 1; 
				answer = Math.min(answer, mid); 
			}else {
				left = mid + 1; 
			}
		}
		
		System.out.println(answer); 
		
	}
	
	static boolean check(int mid) {
		int cnt = 0; 
		
		for(int i=0; i<M; i++) {
			int quo = arr[i] / mid; 
			int rest = ((arr[i] % mid) == 0)? 0 : 1;
			
//			System.out.printf("%d -> %d / %d\n", arr[i], quo, rest); 
			
			cnt += (quo + rest);
			
//			cnt += quo; 
		}
		
		
		// 보석을 못 받아도 된다.
		boolean res = (cnt > N) ? false : true; 
//		System.out.printf("%d > %d (%b)\n",mid, cnt, res);
		
		return res; 
	}

}