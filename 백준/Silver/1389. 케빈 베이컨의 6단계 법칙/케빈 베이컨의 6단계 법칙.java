import java.util.*;
import java.io.*; 

public class Main {
	
	static int N, M, relation[] ,adjMatrix[][]; 
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = 1; 
			adjMatrix[to][from] = 1;
		}
		
//		for(int[] a : adjMatrix) {
//			System.out.println(Arrays.toString(a));
//		}
		
		int minSum = Integer.MAX_VALUE;
		int minNum = Integer.MAX_VALUE;
		
//		relation = new int[N+1]; 
		
		
		for(int i=1; i<N+1; i++) {
			v = new int[N+1]; 
			bfs(i);
			
			int sum = 0; 
			for(int j = 1; j < N+1; j++) {
				sum += v[j]; 
			}
//			System.out.println(sum);
			
			if(sum < minSum) {
				minSum = sum; 
				minNum = i; 
			}
		}
		
		System.out.println(minNum);
		
		
		
	}

	static int[] v; 
	
	private static void bfs(int start) {
//		System.out.println();
		Arrays.fill(v, -1);
		Queue<Integer> q = new ArrayDeque<>();
		
		int depth = 0; 
		
		q.offer(start);
		v[start] = depth; 
		
		while(!q.isEmpty()) {
			int size = q.size(); 
			
			for(int i=0; i<size; i++) {
				int cur = q.poll();
//				System.out.println(cur);
				
				for(int j=1; j<N+1; j++) {
					if(adjMatrix[cur][j] == 0) continue; 
					if(v[j] > -1) continue; 
					
					q.offer(j);
					v[j] = depth+1;
				}
			}
			
			depth++; 
		}
	}
}