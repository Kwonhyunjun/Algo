import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, goals[];
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> deque = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			deque.offerLast(i);
		}
		
		int count = 0; 
		
		st = new StringTokenizer(br.readLine());
		goals = new int[M];
		for(int i=0; i<M; i++) {
			int goal = Integer.parseInt(st.nextToken());
			
			int target_idx = deque.indexOf(goal);
			int half_idx;
			
			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			}else {
				half_idx = deque.size() / 2;
			}
			
			if(target_idx <= half_idx) {
				for(int j=0; j<target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++; 
				}
			}else {
				for(int j=0; j<deque.size()-target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++; 
				}
			}
			
			deque.pollFirst();
		}
	
		System.out.println(count);
		
	}
}