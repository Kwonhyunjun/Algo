import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 * @author kwonhyunjun
 *
 */
public class Main {
	static int N, M, connected;
	static int[][] adjMatrix; 
	static boolean[] v; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjMatrix = new int[N+1][N+1];
		v = new boolean[N+1];
		
		for(int i =0 ; i < M ;i++) {
			st = new StringTokenizer(br.readLine()); 
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = 1; 
			adjMatrix[to][from] = 1; 
		}
		
		bfs(1); 
		System.out.println(connected-1);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque();
		
		q.offer(start); 
		v[start] = true; 
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			connected++; 
			
			for(int i = 1; i<N+1; i++) {
				if(adjMatrix[cur][i] != 1) continue;
				if(v[i]) continue;
				
				q.offer(i);
				v[i] = true;
			}
			
		}
		
	}

}