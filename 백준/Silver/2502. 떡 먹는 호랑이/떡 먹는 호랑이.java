import java.io.*;
import java.util.*;

public class Main {

	static int D, K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] a = new int[D+1];
		int[] b = new int[D+1]; 
		
		a[1] = 1;
		a[2] = 0; 
		b[1] = 0; 
		b[2] = 1;
		
		for(int i=3; i<=D; i++) {
			a[i] = a[i-1] + a[i-2];
			b[i] = b[i-1] + b[i-2];
		}
		
		int first = 0;
		int second = 0;
		
		for(int f=1; f<=K; f++) {
			
			int rest = K -(a[D] * f);
			
			if(rest % b[D] == 0) {
				first = f;
				second = rest / b[D]; 
				break;
			}
		}
		
		System.out.println(first);
		System.out.println(second);
		

	}

}