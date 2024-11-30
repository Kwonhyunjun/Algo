import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		boolean[] isSended = new boolean[31]; 
		
		for(int i=0; i<28; i++) {
			int idx = Integer.parseInt(br.readLine());
			
			isSended[idx] = true; 
		}
		
		int[] notSended = new int[2];
		int idx = 0; 
		for(int i=1; i<31; i++) {
			if(!isSended[i]) {
				notSended[idx++] = i;
			}
		}
		
		System.out.println(notSended[0]);
		System.out.println(notSended[1]);

	}

}