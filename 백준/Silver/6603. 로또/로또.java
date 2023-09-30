import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M; 
	static int[] input; 
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break; 
			
			input = new int[N]; 
			
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken()); 
			}
			// INPUT END 
			nums = new int[6];
			
			combi(0, 0); 
			System.out.println();
		}
		
		
		
	}
	private static void combi(int cnt, int start) {
		if(cnt == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return; 
		}
		
		for(int i=start; i<N; i++) {
			nums[cnt] = input[i]; 
			combi(cnt+1, i+1); 
		}
	}


}