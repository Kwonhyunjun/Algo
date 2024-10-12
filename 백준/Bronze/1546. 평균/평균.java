import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(br.readLine());
	
		int[] original = new int[N]; 
		float[] scores = new float[N];
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			original[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, original[i]); 
		}
		
		float sum = 0f; 
		
		for(int i=0; i<N; i++) {
//			System.out.println(max);
			scores[i] =  ((float) original[i] / max) * 100;
//			System.out.println(scores[i]);
			sum += scores[i]; 
		}
		
		
		
		
		System.out.println(sum / N); 

	}

}