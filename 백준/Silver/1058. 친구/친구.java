import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[][] adjMatrix; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adjMatrix = new boolean[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			char[] charArr = br.readLine().toCharArray();
			
			for(int j=1; j<=N; j++) {
				char cur = charArr[j-1];
				adjMatrix[i][j] = (cur == 'Y') ? true : false;
			}
		}

		
		int answer = 0; 
		for(int i=1; i<=N; i++) {
			answer = Math.max(answer, bfs(i));
		}
		
		System.out.println(answer);
	}
	
	static int bfs(int start) {
		boolean[] v = new boolean[N+1];
		Queue<int[]> q = new ArrayDeque<>();
		
		v[start] = true;
		q.offer(new int[] {start, 0});
		
		int res = -1; 
		
		while(!q.isEmpty()) { 
			int[] cur = q.poll();
			res++; 
			
			for(int i=1; i<=N; i++) {
				if(v[i]) continue;
				if(!adjMatrix[cur[0]][i]) continue;
				if(cur[1] + 1 > 2) continue;
				
				v[i] = true;
				q.offer(new int[] {i, cur[1]+1});
			}
		}
		
		return res; 
	}

}