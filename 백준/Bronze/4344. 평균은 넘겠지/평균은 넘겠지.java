import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			float average = sum / N;
			
//			System.out.printf("average : %f\n", average);
			
			int taller = 0; 
			for(int i=0; i<N; i++) {
				if(arr[i] > average) taller++;
			}
			
//			System.out.printf("taller : %d\n", taller);
		
			
			System.out.printf("%.3f%%\n", ((float) taller / N) * 100);
		}
		

	}

}
