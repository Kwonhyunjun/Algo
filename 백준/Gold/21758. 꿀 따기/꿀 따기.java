import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[], prefixSum[], answer; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()); 
		
		arr = new int[N];
		int smallest = Integer.MAX_VALUE;
		int smallestIdx = 0; 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] < smallest) {
				smallest = arr[i];
				smallestIdx = i; 
			}
		}
		
		// 누적합배열 초기화
		prefixSum = new int[N];
		prefixSum[0] = arr[0];
		for(int i=1; i<N; i++) {
			prefixSum[i] = prefixSum[i-1] + arr[i];
		}

		
		answer = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) { // 버킷
			
			for(int j=1; j<N; j++) {
				calc(0, j, N-1);
			}
			
			for(int j=1; j<N-1; j++) {
				calc(0, N-1, j);
			}
			
			for(int j=0; j<N-1; j++){
				calc(j, N-1, 0);
			}
			
			
		}
		
		System.out.println(answer);

	}
	
	static void calc(int bee1, int bee2, int bucket) {

		int honey1 = honey(bee1, bucket, bee2);
		int honey2 = honey(bee2, bucket, bee1);
		
		answer = Math.max(answer, honey1 + honey2); 
	}
	
	static int honey(int a, int b, int another) {
		int small = 0;
		int big = 0;
		
		if(a < b) {
			small = a;
			big = b;
		}else {
			small = b;
			big = a;
		}
		
		int res = prefixSum[big] - prefixSum[small] + arr[small] ;  
		
		res -= arr[a];
		if(another <= big && another >= small) {
			res -= arr[another];
		}
		
//		System.out.printf("%d ~ %d => %d\n", a, b, res); 
		return res;
	}

}