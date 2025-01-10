import java.io.*;
import java.util.*;

public class Main {
	
	static int T, N;
	static Node[] adjList; 
	static class Node{
		int parent = -1; 
		ArrayList<Integer> child = new ArrayList<>();
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
//			System.out.printf("t: %d\n", t);
			N = Integer.parseInt(br.readLine());
			adjList = new Node[N+1];
			
			for(int i=1; i<=N; i++) {
				adjList[i] = new Node();
			}
			
			for(int i=0; i<N-1; i++) {
				st = new StringTokenizer(br.readLine());
				
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				adjList[child].parent = parent; 
				adjList[parent].child.add(child);
			}
			
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			int ca = findCommonAncestor(node1, node2);
			sb.append(ca).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int findCommonAncestor(int n1 , int n2) {
//		System.out.println(n1 + " " + n2);
		HashSet<Integer> set = new HashSet<>();
		
		int next = n1;
		while(next != -1) {
//			System.out.println(next);
			set.add(next);
			next = adjList[next].parent;
		}
		
//		System.out.println(set);
		
		next = n2;
		while(next != -1) {
//			System.out.println(next);
			if(set.contains(next)) return next; 
			next = adjList[next].parent;
		}
		return -1; 
	}

}