import java.io.*;
import java.util.*;

public class Main {

	static int N, arr[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		int p1 = 0;
		int p2 = 0;
		
		map.put(arr[p1], 1);
		
		int answer = Integer.MIN_VALUE;
		while(++p2 < N) {
			
			int cur = arr[p2]; 
			map.put(cur, map.getOrDefault(cur, 0)+1);
			
			while(map.size() > 2) {
				int out = arr[p1];
				map.put(out, map.get(out)-1);
				
				if(map.get(out) == 0) {
					map.remove(out);
				}
				
				p1++; 
			}
			
			answer = Math.max(answer, p2-p1+1);
		}
		
		answer = (N==1) ? 1 : answer;
		
		System.out.println(answer);
	}

}