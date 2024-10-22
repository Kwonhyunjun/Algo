import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[]; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
			
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(arr); 
//		System.out.println(Arrays.toString(arr));
		
		int M = Integer.parseInt(br.readLine());  
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken()); 
			sb.append(solve(num)).append(" "); 
		}
		
		System.out.println(sb);
	}
	
	static int solve(int num) {
		int res = 0; 
		
		int upper = 0; 
		int lower = Integer.MAX_VALUE; 
		
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2; 
			
//			System.out.printf("%d~%d => %d(%d) \n", left, right, mid, arr[mid]);
			
			if(arr[mid] <= num) {
				left = mid + 1;
				if(arr[mid] == num) upper = Math.max(upper, mid);
			}else {
				right = mid -1; 
			}
		}
		
		left = 0;
		right = N-1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2; 

//			System.out.printf("%d~%d => %d(%d) \n", left, right, mid, arr[mid]);
			
			if(arr[mid] < num) {
				 left = mid + 1; 
				if(arr[mid] == num) lower = Math.min(lower, mid); 
			}else {
				right = mid - 1;
				if(arr[mid] == num) lower = Math.min(lower, mid);
			}
		}
		
		res = (upper == 0 && lower == Integer.MAX_VALUE)? 0 : upper-lower+1; 
		
		return res;
	}

}