import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, talls[]; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		talls = new int[N]; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			talls[i] = Integer.parseInt(st.nextToken());  
		}
		// Input End
		
		
		ArrayList<Integer> diff = new ArrayList<>();
		
		for(int i=1; i<N; i++) {
			diff.add(talls[i] - talls[i-1]); 
		}
		
//		System.out.println(diff);
		
		Collections.sort(diff);
		
		int answer = 0;
		for(int i=0; i<diff.size()-(K-1); i++) {
			answer += diff.get(i);
		}
		
		System.out.println(answer);
	}

}