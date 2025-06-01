import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, X, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0; 
		int right = X-1;
		int max = 0;
		int hap = 0;
		int cnt = 0;
		for(int i=0; i<X; i++) {
			hap += arr[i];
		}
		
		max = hap;
		cnt = 1;
//		System.out.println(hap);
		
		while(true) {
			hap -= arr[left];
			
			left++;
			right++; 
			
			if(right >= N) break;
			
			
			hap += arr[right];
//			System.out.println(hap);
			
			if(max < hap) {
				max = hap;
				cnt = 1;
			}else if(max == hap) {
				cnt++;
			}
			
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			
			System.out.println(max);
			System.out.println(cnt);
		}
	}

}