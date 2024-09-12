import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans; 
	static class Node{
		
		int num, len; 
		
		public Node(int num, int len) {
			this.num = num;
			this.len = len; 
		}
		
	}
	
	static List<Node>[] adjList;
	static boolean v[];

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		
		// 인접리스트
		adjList = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList<>(); 
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			adjList[parent].add(new Node(child, len));
			adjList[child].add(new Node(parent, len));
		}
		
		ans = 0; 
		for(int i=1; i<=N; i++) {
			v = new boolean[N+1];
			v[i] = true;
			dfs(i, 0); 
		}
		
		System.out.println(ans);
		
	}
	
	public static void dfs(int num, int dim) {
		for(Node node : adjList[num]) {
			if(!v[node.num]) {
				v[node.num] = true;
				dfs(node.num, dim + node.len); 
			}
		}
		
		ans = Math.max(ans, dim); 
	}

}