import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[], start, end, answer;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		
		v = new boolean[N];
		
		bfs();
		
		System.out.println(answer);
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0});
		v[start] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == end) {
				answer = cur[1];
				return; 
			}
			
			int d = 1;
			while(true) {
				int left = cur[0] + arr[cur[0]] * d;
				int right = cur[0] + arr[cur[0]] * -d; 
				
				if((left < 0 || left >= N) && (right < 0 || right >=N)) break;
				
				if(!(left < 0 || left >= N)) {
					q.offer(new int[] {left , cur[1]+1});
				}
				
				if(!(right < 0 || right >= N)) {
					q.offer(new int[] {right , cur[1]+1});
				}
				d++;
			}
		}
		
		answer = -1;
	}

}