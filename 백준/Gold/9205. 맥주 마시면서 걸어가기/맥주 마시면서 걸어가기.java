import java.io.*;
import java.util.*;

public class Main {

	static int N, point[][], adjMatrix[][];
	static boolean reached, v[]; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine()); // 편의점 개수
			v = new boolean[N]; 
			reached = false; 
			
			point = new int[N+2][2];
			adjMatrix = new int[N+2][N+2]; 
			
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine()); 
				point[i][0] = Integer.parseInt(st.nextToken()); 
				point[i][1] = Integer.parseInt(st.nextToken()); 
			}
			// Input End

			for(int i=0; i<N+2; i++) {	
				for(int j=i+1; j<N+2; j++) {
					if(dist(point[i], point[j]) <= 1000) {
						adjMatrix[i][j] = adjMatrix[j][i] = 1;
					}
				}
			}
			
			v = new boolean[N+2]; 
			bfs(); 
			
			String ans = reached ? "happy" : "sad"; 
			System.out.println(ans);
		}

	}
	
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque(); 
		
		q.offer(0); 
		v[0] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == N+1) {
				reached = true; 
				return;
			}
			
			for(int i=0; i<N+2; i++) {
				if(v[i]) continue; // 방문했던
				if(adjMatrix[cur][i] == 0) continue; 
				
				q.offer(i); 
				v[i] = true;
			}
		}
	}

	private static int dist(int[] i, int[] j) {
		return Math.abs(i[0] - j[0]) + Math.abs(i[1] - j[1]);
	}
	
	
	
}