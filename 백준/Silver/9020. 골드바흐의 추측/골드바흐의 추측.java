import java.io.*;
import java.util.*;

public class Main {

	static int T; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		for(int i=2; i<=10000; i++) {
			if(isPrime(i)) set.add(i);
		}
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int diff= 10000;
			int n1 = 0;
			int n2 = 0;
			
			for(int i=2; i<=N; i++) {
				if(!set.contains(i)) continue;
				
				if(set.contains(N-i)) {
					if(Math.abs(i - (N-i)) < diff) {
						n1 = i;
						n2 = N-i;
						diff = Math.abs(i - (N-i));
					}
				}
			}
			
			sb.append(n1).append(" ").append(n2).append("\n");
		}
		
		System.out.println(sb);

	}

	static boolean isPrime(int num) {
		boolean res = true; 
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) {
				res = false;
				break;
			}
		}
		
		return res;
	}
}