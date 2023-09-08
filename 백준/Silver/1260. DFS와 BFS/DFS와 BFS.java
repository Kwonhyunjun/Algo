import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static int[][] adjMatrix;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adjMatrix = new int[N+1][N+1];

 		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = 1; 
			adjMatrix[to][from] = 1; 
		}
		
		dfs(V, new boolean[N+1]);
		System.out.println();
		bfs(V, new boolean[N+1]);
	}

	private static void bfs(int start, boolean[] v) {
		Queue<Integer> q = new ArrayDeque(); 
		q.offer(start); 
		v[start] = true; 
		
		while(!q.isEmpty()) {
			int cur = q.poll(); 
			System.out.print(cur + " ");
			
			for(int i=1; i<N+1; i++) {
				if(adjMatrix[cur][i] == 1 && !v[i]) {
					q.offer(i); 
					v[i] = true;
				}
			}
		}
		
	}

	private static void dfs(int start, boolean[] v) {
		System.out.print(start + " ");
		v[start] = true; 
		
		for(int i=1; i<N+1; i++) {
			if(adjMatrix[start][i] == 1 && !v[i]) {
				dfs(i, v);
			}
		}
		
	}

	

	
}