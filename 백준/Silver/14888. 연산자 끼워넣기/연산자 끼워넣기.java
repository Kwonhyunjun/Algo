import java.io.*;
import java.util.*;

public class Main {

	static int N, oper[], nums[], min, max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		oper = new int[4];
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken()); 
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		solve(1, nums[0], oper[0], oper[1], oper[2], oper[3]); 
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void solve(int idx, int res, int plus, int minus, int multiple, int divide) {
//		System.out.println("idx : " + idx + " res : " + res+ " "+ plus + " " + minus + " " + multiple + " " + divide);
		if(idx == N) {
//			System.out.println(res);
			min = Math.min(min, res);
			max = Math.max(max, res); 
			return; 
		}
		
		
		if(plus > 0) {
			solve(idx+1, res + nums[idx], plus-1, minus, multiple, divide);
		}
		
		if(minus > 0) {
			solve(idx+1, res - nums[idx], plus, minus-1, multiple, divide);
		}
		
		if(multiple > 0) {
			solve(idx+1, res * nums[idx], plus, minus, multiple-1, divide);
		}
		
		if(divide > 0) {
			int temp = 0; 
			if(res < 0) {
				temp = res * -1 / nums[idx];
				temp *= -1; 
			}else {
				temp = res / nums[idx]; 
			}
			solve(idx+1, temp, plus, minus, multiple, divide-1);
		}
		
		
		
	}
	
	

}