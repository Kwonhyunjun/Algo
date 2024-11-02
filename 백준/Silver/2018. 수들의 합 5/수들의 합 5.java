import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int N = Integer.parseInt(br.readLine()); 
		
		int answer = 0; 
		
		for(int i=1; i<=N; i++) {
			
			int sum = i;
			int num = i+1; 
			while(true) {
				if(sum > N) break;
				
				if(sum == N) {
					answer++;
					break; 
				}
				
				sum += num; 
				num++; 
			}
			
		}
		
		System.out.println(answer); 
		

	}

}