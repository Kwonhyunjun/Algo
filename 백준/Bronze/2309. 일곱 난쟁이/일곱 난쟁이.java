import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[] nums;
	static boolean[] v; 
	static boolean chk=false;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		nums = new int[9]; 
		v = new boolean[9]; 
		for(int i=0; i<9; i++) {
			nums[i] = Integer.parseInt(br.readLine()); 
		}
		
		Arrays.sort(nums);
		
		solve(0,0, 0); 
	}

	private static void solve(int cnt, int sel,int sum) {
		if(sum > 100) return;
		if(chk) return; 
		if(cnt == 9) {
//			System.out.println(Arrays.toString(v) + " "+sum);
			if(sum == 100 && sel == 7) {
				for(int i=0;i<9;i++) {
					if(v[i]) {
						System.out.println(nums[i]);
						chk = true; 
					}
				}
			}
			return; 
		}
		
		v[cnt] = true; 
		solve(cnt+1, sel+1, sum+nums[cnt]);
		
		v[cnt] = false; 
		solve(cnt+1,sel, sum);
	}

}