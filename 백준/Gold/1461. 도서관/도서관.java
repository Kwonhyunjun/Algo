import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M; 
	static PriorityQueue<Integer> plus, minus;  
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		plus = new PriorityQueue<>((o1, o2) -> -(o1-o2));
		minus = new PriorityQueue<>(); 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken()); 
			if(num < 0) {
				minus.offer(num);
			}else {
				plus.offer(num); 
			}
		}
		
		int dist = 0; 
		int longest = -1; 
		
		// 음수 위치에 있는 책 들고오기
		while(!minus.isEmpty()) {
			
			int cnt = M;
			int maxDist = -1; 
			while(!minus.isEmpty() && cnt-- >0) {
				maxDist = Math.max(maxDist, Math.abs(minus.poll())); 
			}
			
			dist += maxDist * 2; 
			longest = Math.max(maxDist, longest);
//			System.out.println(maxDist + " " + dist); 
		}
		
		// 양수 위치에 있는 책 들고오기
		while(!plus.isEmpty()) {
			
			int cnt = M; 
			int maxDist = -1; 
			
			while(!plus.isEmpty() && cnt-- >0) {
				maxDist = Math.max(maxDist, Math.abs(plus.poll())); 
			}
			
			dist += maxDist * 2; 
			longest = Math.max(maxDist, longest);
//			System.out.println(maxDist  + " " + dist); 
		}
		
		System.out.println(dist-longest);
		
		
	}

}