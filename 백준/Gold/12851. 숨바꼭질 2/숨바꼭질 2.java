import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, min, count;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		min = 100001;
		bfs();

		System.out.println(min+ "\n" + count);
	}
			
	static void bfs() {
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {N, 0});
		int[] move = new int[100001];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(min < move[cur[0]]) continue; 
			if(move[cur[0]] <= min && cur[0] == K) {
				min = move[cur[0]];
				count++; 
			}
			
			for(int i=0; i<3; i++) {
				int nextPos = (i==0) ? cur[0] + 1 : (i==1) ? cur[0] - 1 : cur[0] * 2;
				
				if(nextPos < 0 || nextPos >= 100001) continue; 
				
				if(move[nextPos] == 0 || move[nextPos] >= move[cur[0]]+1) {
					q.offer(new int[] {nextPos, cur[1]+1});
					move[nextPos] = move[cur[0]] + 1; 
				}
 				 
			}
		}
	}
}