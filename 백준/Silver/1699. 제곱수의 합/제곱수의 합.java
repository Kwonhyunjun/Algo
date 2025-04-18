import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[100001];
		
		Arrays.fill(arr, -1);
		arr[1] = 1;
		arr[2] = 2; 
		arr[3] = 3;
		
		System.out.println(solve(N)); 

	}
	
	static int solve(int num) {
		if(num == 0) return 0; 
		if(arr[num] != -1) return arr[num];
		
		int n = (int) Math.sqrt(num);
//		int pow = (int) Math.pow(n , 2); 
//		System.out.printf("num : %d, n : %d, pow : %d\n", num, n, pow);
		
		int res = Integer.MAX_VALUE;
		
		while(n > 0) {
			int pow = (int) Math.pow(n-- , 2);
			res = Math.min(res, solve(num - pow));
			
		}
//		for(int i=num - pow; i>0; i--) {
//			System.out.println(i);
			
//		}
		
//		System.out.println(res);
		return arr[num] = res + 1; 
		
	}

}