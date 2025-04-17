import java.io.*;
import java.util.*;

public class Main {

	static int[] isPrime = new int[123456 * 2 +1];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Arrays.fill(isPrime, -1);
		isPrime[1] = 0;
		isPrime[2] = 1; 
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) break;
			
			int answer = 0;
			for(int i=num+1; i<= num * 2; i++) {
				if(checkPrime(i)) answer++; 
//				System.out.println("i : " + i + " " + checkPrime(i));
			}
			
//			System.out.println();
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static boolean checkPrime(int num) {
		if(isPrime[num] != -1 || num <= 2) {
			return isPrime[num] == 0 ? false : true;
		}
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) {
				isPrime[num] = 0;
				return false;
			}
		}
		
		isPrime[num] = 1;
		return true;
	}
}