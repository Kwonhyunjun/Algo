import java.io.*;
import java.util.*;

public class Main {
	static int N, M, arr[]; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		arr = new int[M]; 
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(arr);
		
		int L = 1; 
		int R = arr[M-1]; 
		
		int ans = -1; 
		
		while(L <= R) {
			int mid = (L + R) / 2; 
//			System.out.printf("%d , %d , %d \n", L, R, mid);
			int cnt = 0; 
			for(int i = M-1; i>=0; i--) {
				int can = arr[i] / mid; 
				if(can == 0) break;
				cnt += can; 
			}
//			System.out.printf("%d -> %d\n", mid, cnt);
			
			if(N <= cnt) {
				L = mid + 1;
				ans = mid; 
			}else {
				R = mid - 1;
			}
		}
		ans = (ans == -1)? 0 : ans; 
		System.out.println(ans);
	}
}