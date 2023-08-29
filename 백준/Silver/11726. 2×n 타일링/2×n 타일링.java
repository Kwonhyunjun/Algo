import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int[] memo = new int[N+3]; 
		
		memo[1] = 1; 
		memo[2] = 2; 
		
		for(int i=3; i<N+1; i++) {
			
			memo[i] = (memo[i-1] + memo[i-2])%10_007; 
			
		}
		
		System.out.println(memo[N]);
	}
}