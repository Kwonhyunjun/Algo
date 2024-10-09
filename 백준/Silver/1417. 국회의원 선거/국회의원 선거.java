import java.io.*;
import java.util.*; 

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int N = Integer.parseInt(br.readLine());
		
		int[] votes = new int[N];
		
		for(int i=0; i<N; i++) {
			votes[i] = Integer.parseInt(br.readLine()); 
		}
		
		int answer = 0; 
		
		while(true) {
			int idx = 0;
			int max = Integer.MIN_VALUE;
			for(int i=1; i<N; i++) {
				if(votes[i] > max) {
					max = votes[i]; 
					idx = i;
				}
			}
			
			if(votes[0] > max) {
				break;
			}
			
			if(votes[0] == max) {
				answer++;
				break;
			}
			
			
				votes[0]++;
				votes[idx]--;
				answer++;
			
			
//			System.out.println(Arrays.toString(votes));
		}
		
		System.out.println(answer);
	}

}