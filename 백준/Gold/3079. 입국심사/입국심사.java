import java.io.*;
import java.util.*;


public class Main {
	
	static int N, M;
	static long[] time;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		 
		long max = 0; 
		time = new long[N];
		
		for(int i=0; i<N; i++) {
			time[i] = Long.parseLong(br.readLine()); 
			max = Math.max(max, time[i]); 
		}
		
		long left = 0;
		long right = max * M; 
		
		long answer = Long.MAX_VALUE;
		
		while(left <= right) {
			long mid = left + (right - left) / 2;
			
			if(isPossible(mid)) {
				right = mid - 1; 
				answer = Math.min(answer, mid);
			}else {
				left = mid + 1; 
			}
		}
		
		System.out.println(answer);

	}

	
	static boolean isPossible(long mid) {
		
		long cnt = 0;
		
		for(long cur : time) {
			cnt += (mid /cur);
			
			if(cnt >= M) break; 
		}
		
		return cnt >= M; 
	}
}