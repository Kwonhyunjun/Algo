import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M; 
	static int[] nums;
	static int[] ans; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[i] = num; 
		}
		Arrays.sort(nums);
		
		comb(0);
	}

	private static void comb(int cnt) {
		if(cnt == M) {
			for(int a : ans) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0 ; i < N ;i++) {
			if(cnt > 0 && ans[cnt-1] > nums[i]) continue; 
			ans[cnt] = nums[i]; 
			comb(cnt+1);
		}
	}

}