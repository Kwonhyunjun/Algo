import java.io.*;
import java.util.*;

public class Main {
	
	static int N, R, Q, size[];
	static Node[] nodes; 
	static class Node{
		int num;
		int parent = -1; 
		ArrayList<Integer> childs = new ArrayList<>();
		
		public Node(int num) {
			this.num = num;
		}
	}
	
	
	static ArrayList<Integer>[] adjList; 
	static boolean[] v;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		size = new int[N+1];
		v = new boolean[N+1];
		
		adjList = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		countSubtreeNodes(R);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Q; i++) {
			sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void countSubtreeNodes(int cur) {
		size[cur] = 1; 
		v[cur] = true;
		for(int next : adjList[cur]) {
			if(v[next]) continue; 
			countSubtreeNodes(next); 
			size[cur] += size[next]; 
		}
	}

}