import java.io.*;
import java.util.*; 

public class Main {
	static int N, M, list[], targets[]; 
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder(); 
		
		
		N = Integer.parseInt(br.readLine()); 
		list = new int[N]; 
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<M; i++) {
			int ans = binarySearch(0, N-1, Integer.parseInt(st.nextToken()));
			sb.append(ans + "\n"); 
		}
		
		System.out.println(sb); 
		
		
	}

	private static int binarySearch(int st, int en, int target) {
		if(en < st) return 0; 
		
		int mid = (st + en)/2; 
		
		if(list[mid] == target) { 
			return 1; 
		}else if(list[mid] < target) {
			return binarySearch(mid+1, en, target); 
		}else {
			return binarySearch(st, mid-1, target); 
		}
	}
}