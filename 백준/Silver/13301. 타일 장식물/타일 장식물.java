import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N+1];
		if(N == 1) {
			System.out.println(4);
		}else if(N == 2) {
			System.out.println(6);
		}else {
			arr[1] = 1;
			arr[2] = 1;
			
			for(int i=3; i<=N; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
			
			System.out.println(2* (arr[N] + arr[N] + arr[N-1]));			
		}

	}

}
