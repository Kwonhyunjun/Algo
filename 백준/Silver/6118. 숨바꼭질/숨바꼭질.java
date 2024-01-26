import java.io.*;
import java.util.*; 

public class Main {
	
	static int N, M, v[], adjMatrix[][];
	static ArrayList<ArrayList<Integer>> adj; 
	static boolean[] visited; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList<>(); 
		
		for(int i=0; i<N+1; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adj.get(from).add(to);
			adj.get(to).add(from); 
		}
		
		v = new int[N+1];
		visited = new boolean[N+1]; 
		Arrays.fill(v, -1);
		int minCnt = bfs(1) -1; 
		
//		System.out.println(Arrays.toString(v));
		
		int num = -1; 
		int cnt = 0; 
		for(int i=N; i > 0; i--) {
//			System.out.println(v[i]);
			if(v[i] == minCnt) {
				cnt++; 
				num = i; 
			}
		}
		
		System.out.printf("%d %d %d", num, minCnt, cnt);
		
	}

	private static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>(); 
		
		q.offer(start);
		v[start] = 0; 
		visited[start] = true; 

		int depth = 0; 
		while(!q.isEmpty()) {
			int size = q.size();
//			System.out.println();
//			System.out.println(depth);
			
			for(int i=0; i<size; i++) {
				int cur = q.poll(); 
//				System.out.println(cur);
				
				
				for(int j=0; j< adj.get(cur).size() ; j++) {
					int num = adj.get(cur).get(j); 
					
					if(visited[num]) continue; // 방문 여부 
					if(v[num] > -1) continue; 
					
					q.offer(num);
					v[num] = depth + 1; 
					visited[num] = true; 
				}
			}
			depth++; 
		}
		return depth; 
	}

}