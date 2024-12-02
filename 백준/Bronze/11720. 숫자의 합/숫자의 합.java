import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		int N = Integer.parseInt(br.readLine());
		String num = br.readLine(); 
		 
		for(int i=0; i<N; i++) {
//			System.out.println(num.charAt(i) - 48);
			sum += num.charAt(i) - 48;
		}
		
		System.out.println(sum);

	}

}