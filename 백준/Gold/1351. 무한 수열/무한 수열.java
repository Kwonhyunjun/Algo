import java.io.*;
import java.util.*;  

public class Main {
	
	static Long N, P, Q; 
	static HashMap<Long, Long> map; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken()); 
		
		map = new HashMap<>();
		map.put(0L, 1L); 
		map.put(1L, 2L); 
		
		
		System.out.println(solve(N)); 
		
	}

//	static Long dfs(long n) {
//		if(n == 0) {
//			return map.get(n); 
//		}
//		System.out.printf("n : %d -> %d + %d\n", n, n/P, n/Q );
//		
//		if(n/P == n/Q) {
//			Long num = 0L; 
//			
//			if(!map.containsKey(n/P)) {
//				map.put(n/P, dfs(n/P) *2);  
//			}
//			
//			return map.get(n/P)*2; 
//		}else {
//			
//			if(!map.containsKey(n/P)) {
//				map.put(n/P, dfs(n/P));  
//			}
//			
//			if(!map.containsKey(n/Q)) {
//				map.put(n/Q, dfs(n/Q));  
//			}
//			
//			return map.get(n/P) + map.get(n/Q); 	
//		}
//		
//	}
	
	static long solve(long num) {
		if(num == 0) return 1; 
		if(map.containsKey(num)) return map.get(num); 
		
		long a = (long) Math.floor(num/P); 
		long b = (long) Math.floor(num/Q); 
		
		map.put(num, solve(a) + solve(b)); 
		return map.get(num); 
	}

}