import java.util.*;
import java.io.*;

public class Main {
	
	static int N, parents[]; 
	static ArrayList<ArrayList<Integer>> adjList;  

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine()); 
		
		adjList = new ArrayList<>();
		parents = new int[N+1]; 
		
		for(int i=0; i<N+1; i++) {
			adjList.add(new ArrayList<>()); 
		}
		
		// 간선 정보 받기
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			adjList.get(to).add(from);
			adjList.get(from).add(to);
		}
		
		Arrays.fill(parents, -1);
		bfs(1); 
		
		StringBuilder sb = new StringBuilder(); 
		for(int i=2; i<N+1; i++) {
			sb.append(parents[i]).append("\n"); 
		}
		
		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>(); 
		
		q.offer(start); 
		parents[start] = 0; 
		
		while(!q.isEmpty()) {
			int cur = q.poll(); 
			
			for(int i=0; i<adjList.get(cur).size(); i++) {
				int next = adjList.get(cur).get(i); 
				
				if(next == parents[cur]) continue; 
				
				q.offer(next);
				parents[next] = cur; 
			}
		}
	}
	
	

}