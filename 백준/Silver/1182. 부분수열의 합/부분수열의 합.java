import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, ans; 
	static int[] nums;
	static int[] isSelected; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		isSelected = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		subSet(0, 0); 
		System.out.println(ans);
	}

	private static void subSet(int cnt, int total) {
		if(cnt == N) {
//			if(total == M) {
//				ans++; 
//			}
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i] == 1) {
					sum += nums[i];
				}
			}
			if(sum == M && total > 0) {
//				System.out.println(Arrays.toString(isSelected));
				
				ans++; 
			}
			return; 
		}
		
		// 포함
//		subSet(cnt+1, total+nums[cnt]);
		isSelected[cnt] = 1;
		subSet(cnt+1, total+1);
		
		// 미포함
//		subSet(cnt+1, total);
		isSelected[cnt] = 0;
		subSet(cnt+1, total);
	
	}

}