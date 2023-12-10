import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		
		int[][] input = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(input[i], -1);
			for(int j=0; j<i+1; j++) {
				input[i][j]= Integer.parseInt(st.nextToken()); 
			}
		}
		
//		for(int[] i : input) {
//			System.out.println(Arrays.toString(i));
//		}
		// Input End
		
		if(N == 1) {
			System.out.println(input[0][0]);
		}else {
			
			// 초기값 설정
			input[1][0] += input[0][0]; 
			input[1][1] += input[0][0]; 
			
			for(int i=2; i<N ;i++) {
				for(int j=0; j<i+1; j++) {
					
					if(j == 0) {
						input[i][0] += input[i-1][0]; 
					}else if(j == i){
						input[i][j] += input[i-1][j-1];  
					}else {
						input[i][j] = (input[i-1][j-1] >= input[i-1][j]) ? 
								input[i][j]+ input[i-1][j-1] : input[i][j]+input[i-1][j];
					}
				}
			}
			
//		System.out.println();
//		for(int[] i : input) {
//			System.out.println(Arrays.toString(i));
//		}
			
			int ans = 0; 
			for(int i=0; i<N; i++) {
				ans = Math.max(ans, input[N-1][i]); 
			}
			
			System.out.println(ans);
		}
		
	}
}