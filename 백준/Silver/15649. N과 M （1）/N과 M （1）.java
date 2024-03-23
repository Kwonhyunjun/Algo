import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, R; 
	static int[] map;
	static int[] nums; 
	static boolean[] v; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		R = sc.nextInt(); 

		map = new int[N]; 
		nums = new int[R]; 
		v= new boolean[N]; 
		
		for(int i=0; i<N; i++) {
			map[i] = i+1; 
		}
		// Input End
		
		perm(0);
	}

	static void perm(int cnt) { // 매개변수
		if(cnt == R) { // 종료조건
			for(int num : nums) {
				System.out.print(num +" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]) {
				continue; 
			}
			
			nums[cnt] = map[i]; 
			v[i] = true; 
			perm(cnt+1);
			v[i] = false;
		}
	}
}
