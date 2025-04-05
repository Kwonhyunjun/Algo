import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static Number[] numbers;
	
	static class Number{
		int num; 
		int strike;
		int ball; 
		
		public Number(int num, int strike, int ball) {
			this.num = num;
			this.strike = strike; 
			this.ball = ball;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		numbers = new Number[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			numbers[i] = new Number(num, strike, ball);
		}
		
		int cnt = 0; 
		
		for(int i=123; i<=987; i++) {
			int hundred = i / 100;
			int tens = (i/10) % 10;
			int digit = i % 10;
			
			if(hundred == 0 || tens == 0 || digit == 0) continue;
			if(hundred == tens || hundred == digit || tens == digit) continue;
			
//			System.out.println(hundred + " " + tens + " " + digit);
			
			if(check(hundred, tens, digit)) cnt ++;
		}
		
		System.out.println(cnt);

	}
	
	static boolean check(int hundred, int tens, int digit) {
		
//		System.out.println(hundred + " " + tens + " " + digit);
		
		for(Number number : numbers) {
			int num_hun = number.num / 100;
			int num_ten = (number.num /10) % 10; 
			int num_dit = number.num % 10;
			
			int strike = 0; 
			int ball = 0;
			
			if(num_hun == hundred) strike++;
			if(num_ten == tens) strike++;
			if(num_dit == digit) strike++;
			
			if(num_hun == tens || num_hun == digit) ball++;
			if(num_ten == hundred || num_ten == digit) ball++;
			if(num_dit == tens || num_dit == hundred) ball++;
			
//			System.out.println("Number : " + number.num + " " + strike + " " + ball);
			
			if(strike != number.strike || ball != number.ball) return false;
		}
		
		return true;
	}

}