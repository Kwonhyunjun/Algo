import java.io.*;
import java.util.*;

public class Main {
		
	static int N, budget[], M, answer; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		budget = new int[N];
		
		int min = Integer.MAX_VALUE;
		int max = -1;
			
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			min = Math.min(budget[i], min);
			max = Math.max(budget[i], max);
		}
		
		M = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = max; 
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(isPossible(mid)) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean isPossible(int mid) {
		int res = 0;
		int temp = -1; 
		
		for(int cur : budget) {
			if(mid > cur) {
				res += cur;
				temp = Math.max(cur, temp);
			}else {
				res += mid;
				temp = Math.max(mid, temp);
			}
		}
		
		if(res<=M) {
			answer = Math.max(temp, answer);
			return true;
		}else {
			return false;
		}
	}

}