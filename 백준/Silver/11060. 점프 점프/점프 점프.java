import java.io.*;
import java.util.*;

public class Main {

	static int N, ans, arr[];
	static boolean v[];  
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 

		N = Integer.parseInt(br.readLine()); 
		arr = new int[N];
		v = new boolean[N];
		ans = -1; 
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		bfs(); 
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>(); 
		q.offer(0); 
		v[0] = true; 
		
		int jump = 0; 
		while(!q.isEmpty()) {
			int size = q.size(); 
			
			for(int i=0; i<size; i++) {
				int curP = q.poll();
				
				if(curP == N-1) {
					ans = jump;
					return; 
				}
				
				int cur = arr[curP]; 
				
				for(int j=1; j<cur+1; j++) {
					int nP = curP + j; 
					
					if(nP >= N) continue; 
					if(v[nP]) continue;
					
					q.offer(nP); 
					v[nP] = true;
				}
			}
			
			jump++;
		}
		
	}

}