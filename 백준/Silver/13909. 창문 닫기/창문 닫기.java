import java.io.*;
import java.util.*;
	
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		for(int i=1; i*i<= N; i++) {
			answer++;
		}
		

		System.out.println(answer);
	}

}