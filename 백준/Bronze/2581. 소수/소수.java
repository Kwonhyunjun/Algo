import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int sum = 0; 
		int min = b; 
		
		for(int i=a; i<=b; i++) {
			if(isPrime(i)) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}

	}
	
	static boolean isPrime(int num) {
		if(num == 1) return false;
		if(num == 2) return true;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true; 
	}

}