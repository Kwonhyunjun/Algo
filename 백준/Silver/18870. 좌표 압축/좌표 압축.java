import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer> li; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		
		int[] list = new int[N];
		int[] temp = new int[N];
		
		st = new StringTokenizer(br.readLine()); 
		
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken()); 
			temp[i] = list[i];
		}
		
		Arrays.sort(temp); 
		
		li = new ArrayList<>(); 
		
		for(int i=0; i<N; i++) {
			if(i == 0 || temp[i] != temp[i-1]) {
				li.add(temp[i]); 
			}
		}
//		System.out.println(li);
		
		for(int i=0; i<N; i++) {
			sb.append(binarySearch(0, li.size(), list[i]) + " ");
		}
		
		System.out.println(sb);
	}

	private static int binarySearch(int st, int en, int target) { 
		
		int mid = (st + en)/2; 
//		System.out.println(mid); 
		
		if(li.get(mid) == target) { 
			return mid; 
		}else if(li.get(mid) < target) {
			return binarySearch(mid+1, en, target); 
		}else {
			return binarySearch(st, mid-1, target); 
		}
	}
	
	
}