import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); 
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		if(next_permutation()) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
		}else {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}
	
	static boolean next_permutation() {
		int idx = N-1;
		
		while(idx > 0 && arr[idx-1] > arr[idx]) {
			idx--; 
		}
		
		if(idx == 0) return false;
//		System.out.println(idx);
		
		int nxt = N-1; 
		
		while(nxt >= idx) {
			if(arr[idx-1] < arr[nxt]) break;
			nxt--;
		}
		
//		System.out.println(nxt);
		
		int temp = arr[idx-1];
		arr[idx-1] = arr[nxt]; 
		arr[nxt] = temp;
		
		nxt = N-1;
		
		while(idx < nxt) {
			temp = arr[idx];
			arr[idx] = arr[nxt];
			arr[nxt] = temp;
			idx++;
			nxt--;
		}
		
		
		return true;
	}

}