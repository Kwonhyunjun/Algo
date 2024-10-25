import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(arr); 
		
		int M = Integer.parseInt(br.readLine()); 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken()); 
//			System.out.println(num);
			
			int left = 0; 
			int right = N-1; 
			boolean flag = false; 
			
			while(left <= right) {
				int mid = left + (right - left) /2;
				
				
				if(arr[mid] < num) {
					left = mid + 1; 
				}else if(arr[mid] > num) {
					right = mid - 1;
				}else {
					flag = true; 
					sb.append(1).append(" ");
					break; 
				}
			}
			
			if(!flag) sb.append(0).append(" "); 
		}
		
		System.out.println(sb);
	}

}