import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(solve(i)) answer++;
		}
		
		System.out.println(answer);
	}
	
	static boolean solve(int i) {
		if(i<10) return true;
		
		List<Integer> digits = new ArrayList<>();
		
		int num = i;
		while(num > 0) {
			digits.add(num%10);
			num /= 10; 
		}
		
//		System.out.println(i);
//		System.out.println(digits);
		
		int diff = digits.get(digits.size()-1) - digits.get(digits.size()-2);
		
		for(int j=digits.size()-2; j>0; j--) {
			if(digits.get(j) - digits.get(j-1) != diff) return false;
		}
		
		return true;
	}

}