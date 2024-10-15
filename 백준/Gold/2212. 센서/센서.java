import java.io.*;
import java.util.*;

public class Main {

	static int N, K, sensors[], answer; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 센서의 개수
		K = Integer.parseInt(br.readLine()); // 집중국의 개수 
		
		sensors = new int[N]; 
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensors); 
		int[] dist = new int[N-1]; 
		
		for(int i=0; i<N-1; i++) {
			dist[i] = sensors[i+1] - sensors[i];  
//			sum += dist[i]; 
		}
		
//		System.out.println(Arrays.toString(dist)); 
		Arrays.sort(dist); 
		
//		for(int i=0; i<K-1; i++) {
//			sum -= dist[N-2-i];
//		}
		
		for(int i=0; i<dist.length - K +1; i++) {
			sum+= dist[i];
		}
		
		System.out.println(sum);
		
	}

}