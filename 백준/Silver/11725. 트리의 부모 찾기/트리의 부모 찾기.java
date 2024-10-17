import java.io.*;
import java.util.*;

public class Main {
	
	static int N, parents[]; 
	static boolean[] v; 
	static ArrayList<Integer>[] adjList; 

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		v = new boolean[N+1];
		
		adjList = new ArrayList[N+1]; 
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			adjList[n1].add(n2);
			adjList[n2].add(n1); 
		}
		
		dfs(1); 
		
		StringBuilder sb = new StringBuilder(); 
		
		for(int i=2; i<N+1; i++) {
		
			sb.append(parents[i]).append("\n");
		}
		
		
		System.out.println(sb);
	}
	
	
	
	static void dfs(int parent) {
		
		ArrayList<Integer> cur = adjList[parent];
		v[parent] = true;
		
		for(int i=0; i<cur.size(); i++) {
			
			int num = cur.get(i);
			if(v[num]) continue; 
			parents[num] = parent; 
			dfs(num); 
		}
	}

}