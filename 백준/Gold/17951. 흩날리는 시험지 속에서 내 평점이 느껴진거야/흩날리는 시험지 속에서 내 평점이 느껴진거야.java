import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, correct[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		correct = new int[N];
		
		int left = 0; 
		int right = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			correct[i] = Integer.parseInt(st.nextToken());
			right += correct[i];
		}
		
		int answer = -1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int sum = 0;
			int groupCnt = 0;
			
			for(int i=0; i<N; i++) {
				sum += correct[i];
				
				if(mid <= sum) {
					sum = 0;
					groupCnt++;
				}
			}
			
			if(K <= groupCnt) {
				left = mid + 1; 
			}else {
				right = mid - 1; 
			}
			
		}
		
		System.out.println(right);

	}

}