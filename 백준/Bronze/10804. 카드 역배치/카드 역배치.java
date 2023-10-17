import java.util.Scanner;

public class Main {
static int[] nums;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		nums = new int[20];
		
		for(int i=0; i<20; i++) {
			nums[i] = i+1; 
		}
		
		for(int i=0; i<10; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			swap(a, b); 
		}
		
		for(int num : nums) {
			System.out.print(num+" ");
		}
	}

	private static void swap(int a, int b) {
		while (a < b) {
			int temp = nums[a];
			nums[a] = nums[b];
			nums[b] = temp;
			a++; 
			b--; 
		}
		
	}
	
}